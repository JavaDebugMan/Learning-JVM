package com.javaman.rpc;

/**
 * @author pengzhe
 * @date 2018/6/20 18:51
 * @description
 */

public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        service.hello2("23123");
      /*  for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello2("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }*/
    }
}
