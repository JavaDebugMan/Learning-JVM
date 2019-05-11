package com.javaman.classloader;

/**
 * @author pengzhe
 * @date 2019-05-11 10:27
 * @description
 */

public class Singleton {
    private static int x = 0;
    private static int y;
    private static Singleton instance = new Singleton();
    private Singleton() {
        x++;
        y++;
    }
    public static Singleton getInstance() {
        return instance;
    }
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}














