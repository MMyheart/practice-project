package com.myheart.cluster.simple;

/**
 * @author yangxin
 * @date 2020/2/27
 */
public class ConRumTemp {
    public static void main(String[] args) throws Exception {
        Consumer consumerRam = new Consumer(
                "127.0.0.1",
                5672,
                "cluster.disc.new.queue1"
        );

        consumerRam.consumeOnesleep();
        Thread.sleep(20000);
        consumerRam.test();
    }
}
