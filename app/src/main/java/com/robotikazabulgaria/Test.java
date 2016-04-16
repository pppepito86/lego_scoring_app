package com.robotikazabulgaria;

/**
 * Created by Bobi Mitov on 16.4.2016 г..
 */
public class Test {

    int i;
    String s;

    public Test(int i) {
        this(i, "");
    }

    public Test(int i, String s) {
        this.i = i;
        this.s = s;
    }

    public static void test() {
        Test test1 = new Test(1);
        Test test2 = new Test(1, "aaa");

    }
}
