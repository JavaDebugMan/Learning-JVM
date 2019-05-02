package com.javaman.gc;

/**
 * @author pengzhe
 * @date 2018/4/15 10:07
 * @description -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -Xms40M
 * -Xmx40M
 * -Xmn20M
 */

public class TestHeapGC {

    private static final int _1MB = 2014 * 1024;

    public static void main(String[] args) {


        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];


        /*byte[] b1 = new byte[1024 * 1024 / 2];
        byte[] b2 = new byte[1024 * 1024 * 8];
        b2 = null;
        //进行一次新生代
        b2 = new byte[1024 * 1024 * 8];*/
        //System.gc();
    }

}
