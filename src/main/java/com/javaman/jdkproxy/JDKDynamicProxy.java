package com.javaman.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author pengzhe
 * @date 2018/6/8 16:25
 * @description JDK动态代理类
 * <p>
 * 参数说明：
 * Object proxy：指被代理的对象
 * Method method：我们所要调用被代理对象的某个方法的Method对象
 * Object[] args：被代理对象某个方法调用时所需要的参数
 * <p>
 * 可以将InvocationHandler接口的子类想象成一个代理的最终操作类。
 * 说明：每一个动态代理类都必须要实现InvocationHandler这个接口，
 * 并且每个代理类（Proxy）的实例都关联到了一个handler，
 * 当我们通过代理对象调用一个方法的时候，
 * 这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。
 * 同时在invoke的方法里
 * 我们可以对被代理对象的方法调用做增强处理(如添加事务、日志、权限验证等操作)。
 */

public class JDKDynamicProxy implements InvocationHandler {

    //我们要代理的真实对象(委托对象)
    private Object subject;

    //构造方法,我们要给代理的真实对象赋初值
    public JDKDynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在代理对象操作前,我们可以添加一些自己的操作
        System.out.println("before proxy invoke");

        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);

        // 在代理真实对象操作后 我们也可以添加一些自己的操作
        System.out.println("after proxy invoke");

        return null;
    }
}
