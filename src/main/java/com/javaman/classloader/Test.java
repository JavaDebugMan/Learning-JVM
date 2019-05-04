package com.javaman.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author pengzhe
 * @date 2019-05-02 21:59
 * @description
 */

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println(Test.class.getClassLoader());

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Class<?> aClass = classLoader.loadClass("com.javaman.classloader.Test");
        System.out.println(aClass.getClassLoader());
    }

}
