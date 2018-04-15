package com.javaman.gc;

/**
 * @author pengzhe
 * @date 2018/4/15 10:07
 * @description
 *
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -Xms40M
 * -Xmx40M
 * -Xmn20M
 */

public class TestHeapGC {

    public static void main(String[] args) {
        byte[] b1 = new byte[1024 * 1024 / 2];
        byte[] b2 = new byte[1024 * 1024 * 8];
        b2 = null;
        //进行一次新生代
        b2 = new byte[1024 * 1024 * 8];
        //System.gc();
    }

}
