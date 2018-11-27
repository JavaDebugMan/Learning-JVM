package com.javaman.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pengzhe
 * @date 2018-11-27 23:22
 * @description
 */

public class TestClassloader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("com.javaman.classloader.HelloWorld");
        System.out.println(aClass.getClassLoader());

        Object instance = aClass.newInstance();
        System.out.println(instance);

        Method welcome = aClass.getMethod("welcome");
        String invoke = (String)welcome.invoke(instance);
        System.out.println("Result---》"+invoke);

    }
}
