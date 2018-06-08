package com.javaman.cglibfilter;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @author pengzhe
 * @date 2018/6/5 18:30
 * @description
 */

public class DaoAnotherProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {

        System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
        proxy.invokeSuper(object, objects);
        System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
        return object;
    }

}
