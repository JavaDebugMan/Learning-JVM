package com.javaman.classloader;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author pengzhe
 * @date 2019-05-02 12:01
 */
public class JvmClassLoader extends ClassLoader {
    private String classPath;

    public JvmClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 自定义类加载器继承自ClassLoader,称为一个可以加载类的类加载器,同时复写loadClass()方法,实现自己的加载逻辑
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //排除掉加载系统默认需要加载的核心类,因为这些类只能由默认类加载器去加载,第三方加载会抛异常
        if (!name.contains("java.lang")) {
            byte[] data = new byte[0];
            try {
                data = loadByte(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(name, data, 0, data.length);
        } else {
            return super.loadClass(name);
        }

    }

    /**
     * 把二进制文件类读如内存字节流
     *
     * @param name
     * @return
     */
    private byte[] loadByte(String name) throws IOException {
        String s = name.replaceAll("\\.", "/");
        String dir = classPath + "/" + s + ".class";
        FileInputStream fileInputStream = new FileInputStream(dir);
        int length = fileInputStream.available();
        byte[] data = new byte[length];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }
}
