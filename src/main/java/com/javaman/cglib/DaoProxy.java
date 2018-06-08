package com.javaman.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author pengzhe
 * @date 2018/6/5 18:22
 * @description
 */

public class DaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method,
                            Object[] objects, MethodProxy proxy) throws Throwable {

        System.out.println("Before Method Invoke");

        proxy.invokeSuper(object, objects);

        System.out.println("After Method Invoke");

        return object;
    }
}
