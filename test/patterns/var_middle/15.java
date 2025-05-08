// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Yegor Bugayenko
// SPDX-License-Identifier: MIT

package javalang.brewtab.com;

class Test {

    public void returnsIteratorWithSupportedRemove() {
        final CollectionEnvelope<String> list = new CollectionEnvelope<String>(
            new CollectionOf<>("eleven")
        ) {
        };
        final Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        new Assertion<>(
            "Must return an empty Iterator",
            new IterableOf<>(iterator),
            new IsEmptyIterable<>()
        ).affirm();
    }

}
