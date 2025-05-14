// SPDX-FileCopyrightText: Copyright (c) 2019-2025 Aibolit
// SPDX-License-Identifier: MIT

import java.util.ArrayList;

class HolyMoly {

    class NestedDummy {

        NestedDummy methodInv1(Object obj) {
            return new NestedDummy();
        }

        NestedDummy methodInv2(Object obj) {
            return new NestedDummy();
        }

        NestedDummy methodInv3(Object obj) {
            return new NestedDummy();
        }

        NestedDummy methodInv4(Object obj) {
            return new NestedDummy();
        }
    }

    class MyObject {

        MyObject SpecifySomeParameter(Object obj) {
            return new MyObject();
        }

        MyObject SpecifySomeOtherParameter(Object obj) {
            return new MyObject();
        }

        MyObject Execute(Object obj) {
            return new MyObject();
        }

        MyObject Start() {
            return new MyObject();
        }

        MyObject SpecifySomeAnotherParameter(Object obj) {
            new MyObject();
        }
    }

    public void start() {
        int aaa = 1;
        String bbb = "opa";
        System.out.println("asdasd" + aaa + "34234" + bbb);
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++)
            list.add(Boolean.FALSE);
        list = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++)
            list.add(Boolean.FALSE);


        NestedDummy obj = new NestedDummy();
        obj.methodInv1(list).methodInv2("blabla").methodInv3(new Thread() {
            public void run() {
                ArrayList<Boolean> list = new ArrayList<Boolean>();
                for (int i = 0; i < 10; i++)
                    for (int j = 0; j < 10; j++)
                        list.add(Boolean.FALSE);

                new MyObject().Start()
                        .SpecifySomeParameter(list)
                        .SpecifySomeOtherParameter("list")
                        .Execute(new Thread() {
                            public void run() {
                                ArrayList<Boolean> list = new ArrayList<Boolean>();
                                for (int i = 0; i < 10; i++)
                                    for (int j = 0; j < 10; j++)
                                        list.add(Boolean.FALSE);

                                new MyObject().Start()
                                        .SpecifySomeParameter(list)
                                        .SpecifySomeOtherParameter("list")
                                        .Execute("");
                            }
                        }).SpecifySomeAnotherParameter("end");
            }
        }).methodInv4("end");

    }


    public void doNothing() {
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                list.add(Boolean.FALSE);
    }
}
