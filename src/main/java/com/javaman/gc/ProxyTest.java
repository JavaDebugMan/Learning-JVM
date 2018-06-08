package com.javaman.gc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pengzhe
 * @date 2018/5/17 14:49
 * @description
 */

public class ProxyTest {

    interface IHello {
        /**
         *wer
         */
        void sayHello();
    }

    static class Hello implements IHello {

        public void sayHello() {
            System.out.println("sayHello");
        }
    }

    static class DynaticProxy implements InvocationHandler {

        Object origalObj = null;

        Object bind(Object origalObj) {
            this.origalObj = origalObj;
            return Proxy.newProxyInstance(origalObj.getClass().getClassLoader(),
                    origalObj.getClass().getInterfaces(), this);

        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome");
            return method.invoke(origalObj, args);
        }
    }


    public static void main(String[] args) {
        IHello iHello = (IHello) new DynaticProxy().bind(new Hello());
        iHello.sayHello();

    }


}
