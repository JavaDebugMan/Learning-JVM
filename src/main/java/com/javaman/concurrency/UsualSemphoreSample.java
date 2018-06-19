package com.javaman.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author pengzhe
 * @date 2018/6/19 15:23
 * @description 通过一定数量的允许(permit)的方式, 来达到限制通用资源访问的目的
 * 举个栗子:
 * 在车站,机场等出租车时,当很多出租车就位时,为防止过度拥挤,调度员指挥排队等待坐车的队伍一次进来5个人上车
 * 等这5个人坐车出发,再放进去下一批
 */

public class UsualSemphoreSample {

    public static void main(String[] args) {
        System.out.println("Action Go");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SemphoreWorker(semaphore));
            thread.start();
        }
    }

    static class SemphoreWorker implements Runnable {

        private String name;
        private Semaphore semaphore;

        public SemphoreWorker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                log("is waiting for a permit");
                semaphore.acquire();
                log("acquired a permit!");
                log("executed");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log("released a permit");
                semaphore.release();
            }

        }

        private void log(String msg) {
            if (name == null) {
                name = Thread.currentThread().getName();
            }
            System.out.println(name + "----->" + msg);

        }
    }

}
