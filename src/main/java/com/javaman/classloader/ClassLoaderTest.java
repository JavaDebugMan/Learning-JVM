package com.javaman.classloader;

import static java.lang.System.out;

/**
 * @author pengzhe
 * @date 2019-05-02 11:38
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            //定义要加载的类的全限定类名
            String className = "com.javaman.classloader.JvmClass";

            //第一个类由系统默认类加载器加载
            Class<?> systemClassLoader = JvmClass.class;
            //第二个由自定义的类加载器加载,目的是覆盖加载类的逻辑
            Class<?> myclassLoader = new JvmClassLoader("/Users/pengzhe/code/Learning-JVM/target/classes").loadClass(className);

            out.println("-----------------ClassName-----------------");
            out.println(systemClassLoader.getName());
            out.println(myclassLoader.getName());
            out.println("-----------------ClassLoaderName-----------------");
            out.println(systemClassLoader.getClassLoader());
            out.println(myclassLoader.getClassLoader());

            //这里修改系统类加载器加载的那个类的属性,而自定义类加载器加载的不变
            JvmClass.example = 1;
            out.println("-----------------FieldValue-----------------");
            out.println(systemClassLoader.getDeclaredField("example").get(null));
            out.println(myclassLoader.getDeclaredField("example").get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
