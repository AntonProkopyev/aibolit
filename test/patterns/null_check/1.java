// SPDX-FileCopyrightText: Copyright (c) 2019-2025 Aibolit
// SPDX-License-Identifier: MIT

class Foo {
    private String z;
    void x() {
      if (this.z == null) { // here!
        throw new RuntimeException("oops");
      }
    }
  }
