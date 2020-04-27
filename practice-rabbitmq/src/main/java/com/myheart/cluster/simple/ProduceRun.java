package com.myheart.cluster.simple;

/**
 * @author yangxin
 * @date 2020/2/27
 */
public class ProduceRun {
    public static void main(String[] args) throws Exception {
        Producer producerDisc = new Producer(
                "127.0.0.1:5674",
                5674,
                "disc.exchange3",
                "disc.rout3");

//        Producer producerRam = new Producer(
//                "127.0.0.1:5672,127.0.0.1:5673,127.0.0.1:5674",
//                5673,
//                "cluster.ram.new.exchange1",
//                "cluster.ram.new.key1");

        producerDisc.Initialize();
//        producerRam.Initialize();

//        producerDisc.produce("disc-one");
//        producerDisc.produce("disc-two");
//
//        producerRam.produce("ram-one");
//        producerRam.produce("ram-two");

        int i = 1000;
        while(i > 950){
//            Thread.sleep(1000);
            producerDisc.produce("disc-"+i);
//            producerRam.produce("ram-"+i);
            i--;
        }

        producerDisc.stop();
//        producerRam.stop();

//        Producer producerDisc = new Producer(
//                "127.0.0.1:5674",
//                5672,
//                "cluster.same.exchange5",
//                "cluster.same.key5");
//        producerDisc.Initialize();
//        producerDisc.produce("test mirror two");
//        producerDisc.stop();

//        Producer producerDisc = new Producer(
//                "127.0.0.1:5674",
//                5672,
//                "cluster.ram.new.exchange1",
//                "cluster.ram.new.key1");
//        producerDisc.Initialize();
//        producerDisc.produce("test mirror un_synchronized");
//        producerDisc.stop();
    }
}
