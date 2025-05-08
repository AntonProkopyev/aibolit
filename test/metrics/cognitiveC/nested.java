// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Yegor Bugayenko
// SPDX-License-Identifier: MIT

class LengthStringComparator implements Comparator<String> {
    boolean validate() {
   return new Object() {
     boolean check(Struct struct) {
       if (!struct.valid()) return false;
       for(Struct child : struct.children()) {
         if (!check(child)) return false;
       }
       return true;
     }
   }.check(_struct);
}

	public static void main(String[] args)
    {
        int test = 3;
        main(test);
    }

}
