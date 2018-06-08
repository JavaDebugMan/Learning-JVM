package com.javaman.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author pengzhe
 * @date 2018/6/5 21:14
 * @description
 */

public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
