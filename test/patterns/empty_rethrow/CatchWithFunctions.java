// SPDX-FileCopyrightText: Copyright (c) 2019-2025 CQFN.org
// SPDX-License-Identifier: MIT

class Book {
  void func() {}
  void func2() {}

  void foo() throws IOException, AnyException {
    try {
      Files.readAllBytes();
    } catch (IOException e) { // here
      int i = 0;
	  i++;
	  func();
	  func2();
	  throw e;
    }
  }
}
