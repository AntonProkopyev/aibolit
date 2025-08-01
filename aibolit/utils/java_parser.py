# SPDX-FileCopyrightText: Copyright (c) 2019-2025 Aibolit
# SPDX-License-Identifier: MIT

from typing import List, Type

import javalang
import javalang.ast
import javalang.tree


# mapping between javalang node class names and Java keywords
NODE_KEYWORD_MAP = {
    'SuperMethodInvocation': 'super',
    'WhileStatement': 'while',
    'ForStatement': 'for',
    'TryStatement': 'try',
    'CatchClause': 'catch',
    'SynchronizedStatement': 'synchronized'
}

# list of nodes creating new scope
NEW_SCOPE_NODES = [
    javalang.tree.MethodDeclaration,
    javalang.tree.IfStatement,
    javalang.tree.ForStatement,
    javalang.tree.SwitchStatement,
    javalang.tree.TryStatement,
    javalang.tree.DoStatement,
    javalang.tree.WhileStatement,
    javalang.tree.BlockStatement,
    javalang.tree.CatchClause,
    javalang.tree.SynchronizedStatement
]


class ASTNode:
    def __init__(self, line, method_line, node, scope):
        self.line = line  # node line number in the file
        self.method_line = method_line  # line number where parent method declared
        self.node = node  # javalang AST node object
        self.scope = scope  # ID of scope this node belongs


class JavalangImproved:
    """
    This class flattens AST to provie easier interface.

    Deprecated: flatening the AST leads to lose of information and bugs.
    All patterns using it should start traversing the tree manually.
    """

    def __init__(self, tree, lines):
        self.tree = tree
        self.lines = lines

    def __find_keyword(self, lines, keyword, start):
        """
        Args:
            lines (List[str]): List of lines from parsed source code file
            keyword (str): keyword to find
            start (int): Line number to start search
        """
        for i in range(start - 1, len(lines)):
            if keyword in lines[i]:
                return i + 1
        return -1

    def __fix_line_number_if_possible(self, node: javalang.ast.Node, line_n):
        '''
        Try to figure out the "true" line number of AST node in the source file
        '''
        node_class_name = node.__class__.__name__
        if node_class_name not in NODE_KEYWORD_MAP:
            return line_n
        line = self.__find_keyword(
            self.lines,
            NODE_KEYWORD_MAP[node_class_name],
            line_n
        )
        if line == -1:
            return line_n
        return line

    def __tree_to_nodes(
        self,
        tree: javalang.ast.Node,
        line=1,
        parent_method_line=None,
        scope=0
    ) -> List[ASTNode]:
        """
        Return AST nodes with line numbers sorted by line number

        Args:
            tree (javalang.ast.Node): AST node
            line (int): Supposed line number of processed AST node in the file
            parent_method_line (int): Nearest line number of the method this node located
            scope (int): ID of scope processed AST node located
        """

        if hasattr(tree, 'position') and tree.position:
            line = tree.position.line

        line = self.__fix_line_number_if_possible(tree, line)
        if type(tree) in NEW_SCOPE_NODES:
            scope += 1

        if type(tree) in [javalang.tree.MethodDeclaration,
                          javalang.tree.ConstructorDeclaration,
                          javalang.tree.LambdaExpression]:
            parent_method_line = line

        res: List[ASTNode] = []
        for child in tree.children:
            nodes_arr = child if isinstance(child, list) else [child]
            for node in nodes_arr:
                if not hasattr(node, 'children'):
                    continue
                left_siblings_line = res[-1].line if len(res) > 0 else line
                res += self.__tree_to_nodes(
                    node,
                    left_siblings_line,
                    parent_method_line,
                    scope
                )

        return [ASTNode(line, parent_method_line, tree, scope)] + res

    def tree_to_nodes(self) -> List[ASTNode]:
        """Return AST nodes as list with line numbers sorted by line number"""
        nodes = self.__tree_to_nodes(self.tree)
        return sorted(nodes, key=lambda v: v.line)

    def filter(self, ntypes: List[Type[javalang.tree.Node]]) -> List[ASTNode]:
        nodes = self.tree_to_nodes()
        return list(
            filter(lambda v: type(v.node) in ntypes, nodes)
        )

    def empty_lines(self) -> List[int]:
        """Figure out lines that are either empty or multiline statements"""
        lines_with_nodes = self.non_empty_lines()
        max_line = max(lines_with_nodes)
        return list(set(range(1, max_line + 1)).difference(lines_with_nodes))

    def non_empty_lines(self) -> List[int]:
        """Figure out file lines that contains statements"""
        return list(map(lambda v: v.line, self.tree_to_nodes()))
