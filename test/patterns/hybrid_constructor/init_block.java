// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Yegor Bugayenko
// SPDX-License-Identifier: MIT

public class TempG extends Base {

    private int i;

    {
        System.out.println("init block super of TempG");
    }

    public TempG(int i) {
        this.i = i;
    }

    public TempG() {
        this(4);
    }

    public static void main(String[] args) {
        System.out.println("START!");
        TempG a = new TempG();
    }
}
