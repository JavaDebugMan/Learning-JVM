package com.javaman.rpc;

/**
 * @author pengzhe
 * @date 2018/6/20 18:51
 * @description 暴露服务
 */

public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
