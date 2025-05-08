// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Yegor Bugayenko
// SPDX-License-Identifier: MIT

import java.lang.Math;

class T2 {
    public int square (int n) {
        return (int) java.lang.Math.pow(n,2);
    }
}

class T1 {
    public static void main(String[] arg) {
        T2 x1 = new T2();
        double m =x1.square(3);
        System.out.println(m);
    }
}
