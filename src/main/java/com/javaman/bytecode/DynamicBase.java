package com.javaman.bytecode;

import java.lang.management.ManagementFactory;

/**
 * @author pengzhe
 * @date 2019-09-06 14:57
 */
public class DynamicBase {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    private static void process() {
        System.out.println("process");
    }
}
