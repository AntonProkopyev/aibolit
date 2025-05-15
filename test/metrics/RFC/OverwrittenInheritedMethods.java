// SPDX-FileCopyrightText: Copyright (c) 2019-2025 Aibolit
// SPDX-License-Identifier: MIT
// Total RFC = 2

public class BaseClass {                            // class RFC = 1
    public void publicMethod() {                    // +1 for public method
    }
}

public class DerivedClass extends BaseClass {       // class RFC = 1
    public void publicMethod() {                    // +1 for public method
        super.publicMethod();                       // calling inherited method do not count
    }
}
