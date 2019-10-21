package com.javaman.bytecode.Instrument;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

/**
 * 字节码增强
 * https://mp.weixin.qq.com/s/CH9D-E7fxuu462Q2S3t0AA
 * 在IDEA中将一个类打成jar
 * https://www.cnblogs.com/yougewe/p/9651156.html
 *
 * @author pengzhe
 * @date 2019-09-06 15:49
 */
public class Attacher {
    public static void main(String[] args)
        throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine machine = VirtualMachine.attach("4932");
        machine.loadAgent("/Users/pengzhe/code/Learning-JVM/classes/artifacts/agent/agent.jar");
    }
}
