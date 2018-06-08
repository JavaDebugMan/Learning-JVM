package com.javaman.cglibfilter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author pengzhe
 * @date 2018/6/5 18:31
 * @description
 */

public class DaoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }

}
