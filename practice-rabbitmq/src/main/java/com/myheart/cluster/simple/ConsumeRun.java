package com.myheart.cluster.simple;

/**
 * @author yangxin
 * @date 2020/2/27
 */
public class ConsumeRun {
    public static void main(String[] args) throws Exception {
        Consumer consumerDisc = new Consumer(
                "127.0.0.1",
                5674,
                "disc.queue3"
        );

//        Consumer consumerRam = new Consumer(
//                "127.0.0.1",
//                5672,
//                "cluster.disc.new.queue1"
//        );

        consumerDisc.consumeOne();
//        consumerRam.consumeOnesleep();
    }
}
