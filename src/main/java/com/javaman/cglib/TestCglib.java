package com.javaman.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author pengzhe
 * @date 2018/6/5 18:24
 * @description
 */

public class TestCglib {

    public static void main(String[] args) {

        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (Dao) enhancer.create();
        dao.update();
       //dao.select();

    }


}
