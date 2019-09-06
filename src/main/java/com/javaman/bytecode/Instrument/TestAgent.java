package com.javaman.bytecode.Instrument;

import java.lang.instrument.Instrumentation;

import com.javaman.bytecode.DynamicBase;

/**
 * @author pengzhe
 * @date 2019-09-06 15:05
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(DynamicBase.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
