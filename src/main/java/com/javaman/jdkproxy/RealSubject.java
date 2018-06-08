package com.javaman.jdkproxy;

/**
 * @author pengzhe
 * @date 2018/6/8 16:23
 * @description 被代理类
 */

public class RealSubject implements Subject {

    @Override
    public void visit() {
        System.out.println("I am 'RealSubject',I am execution method now");
    }
}
