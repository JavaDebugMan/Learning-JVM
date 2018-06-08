package com.javaman.gc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pengzhe
 * @date 2018/6/5 17:17
 * @description
 */

public class JDKProxy {

    interface Hello {
        void sayHello();
    }

    static class HelloImpl implements Hello {
        @Override
        public void sayHello() {
            System.out.println("Hello word");
        }
    }

    static class MyInvocationHandler implements InvocationHandler {

        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("调用目标方法之前");
            Object result = method.invoke(target, args);
            System.out.println("调用目标方法后");
            return result;
        }
    }

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);
        //构造代理实例
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(), myInvocationHandler);
        //调用代理方法
        proxyHello.sayHello();

        System.out.println("未使用代理-------------------------------------------------------");

        hello.sayHello();

    }


}
