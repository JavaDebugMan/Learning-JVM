package com.javaman.jdk;

/**
 * @author pengzhe
 * @date 2019-05-11 11:02
 * @description
 */

public class Son extends Father {

    private int parent;

    protected String fatherMethod() {
        return "Son";
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.parent);
        System.out.println(son.fatherMethod());
    }
}
