package com.javaman.rpc;

/**
 * @author pengzhe
 * @date 2018/6/20 18:50
 * @description 实现服务
 */

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello";
    }

    @Override
    public String hello2(String name) {
        return "Hello2";
    }
}
