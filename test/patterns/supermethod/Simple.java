// SPDX-FileCopyrightText: Copyright (c) 2019-2025 Aibolit
// SPDX-License-Identifier: MIT

public class SubClass extends SuperClass {

  @Override
  public void method1() {
    System.out.println("subclass method1");
    super.method1();
  }

  @Override
  public void method2() {
    System.out.println("subclass method2");
  }
}
