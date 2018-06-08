package com.javaman.cglibproxy;

/**
 * @author pengzhe
 * @date 2018/6/8 16:33
 * @description 没有实现接口的代理委托类
 */

public class CglibRealSubject {
    public void visit() {
        System.out.println("I am 'RealSubject',I am the execution method");
    }
}

