package com.javaman.jdk;

/**
 * @author pengzhe
 * @date 2018/6/1 16:22
 * @description
 */

public class StringTest {

    public static void main(String[] args) {
        String s = "abc";
        String intern = s.intern();

        System.out.println(intern);

        System.out.println(s==intern);

        String s1 = new String("abc");

        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());

        System.out.println(s.toString());
        System.out.println(s1.toString());

        System.out.println(s.equals(s1));

        System.out.println(s==s1);

        while (true) {
            System.out.println("666666666");
        }
    }
}
