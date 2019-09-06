package com.javaman.bytecode;

/**
 * @author pengzhe
 * @date 2019-09-06 11:20
 */
public class ByteCodeDemo {
    public static void main(String[] args) {
        System.out.println(add());
    }
    private static int a = 1;

    private static int add() {
        int b = 2;
        int c = a + b;
        System.out.println(c);
        return c;
    }
}
