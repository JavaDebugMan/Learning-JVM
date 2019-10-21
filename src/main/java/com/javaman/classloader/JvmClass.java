package com.javaman.classloader;

/**
 * @author pengzhe
 * @date 2019-05-02 12:03
 */
public class JvmClass {
    public static int example = 0;

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader().toString());
    }
}
