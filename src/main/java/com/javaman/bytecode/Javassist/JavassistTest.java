package com.javaman.bytecode.Javassist;

import java.io.IOException;

import com.javaman.bytecode.Base;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author pengzhe
 * @date 2019-09-06 14:21
 */
public class JavassistTest {
    public static void main(String[] args)
        throws CannotCompileException, NotFoundException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.javaman.bytecode.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/pengzhe/code/Learning-JVM/src/main/java/com/javaman/bytecode/Javassist");
        Base h = (Base)c.newInstance();
        h.process();
    }
}
