package com.javaman.cglibfilter;

import com.javaman.cglib.Dao;
import com.javaman.cglib.DaoProxy;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author pengzhe
 * @date 2018/6/5 18:32
 * @description
 */

public class Test {

    public static void main(String[] args) {

        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao) enhancer.create();
        dao.update();
        dao.select();

    }
}
