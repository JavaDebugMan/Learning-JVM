package com.javaman.cglibproxy;

/**
 * @author pengzhe
 * @date 2018/6/8 16:36
 * @description 对没有实现接口的普通类做代理
 * 1、概述：
 * <p>
 * Cglib是一个优秀的动态代理框架，它的底层使用ASM（JAVA字节码处理框架）
 * 在内存中动态的生成被代理类的子类。
 * 使用CGLIB即使被代理类没有实现任何接口也可以实现动态代理功能。
 * 但是不能对final修饰的类进行代理。
 * <p>
 * 2、原理：
 * <p>
 * 通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用。
 * <p>
 * <JDK动态代理与CGLib动态代理均是实现Spring AOP的基础>
 * <p>
 * 3、使用:
 * <p>
 * 使用Cglib前需要导入以下两个jar文件：
 * asm.jar – Cglib的底层实现。
 * <p>
 * 【cglib包的底层是使用字节码处理框架ASM来转换字节码并生成新的类，所以cglib包要依赖于asm包】
 * cglib.jar - Cglib的核心jar包。
 */

public class CglibClient {
    public static void main(String[] args) {
        CglibDynamicProxy cglib = new CglibDynamicProxy();
        CglibRealSubject realSubject = (CglibRealSubject) cglib.getProxyInstance(new CglibRealSubject());
        realSubject.visit();
    }
}
