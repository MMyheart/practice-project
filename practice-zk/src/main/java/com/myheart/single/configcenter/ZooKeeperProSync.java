package com.myheart.single.configcenter;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangxin
 * @date 2020/2/17
 */
public class ZooKeeperProSync implements Watcher {

    private static String root = "/zkSingleWatcher";

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        zk = new ZooKeeper("127.0.0.1:2181", 10000, new ZooKeeperProSync());

        connectedSemaphore.await();
        System.out.println(new String(zk.getData(root, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println(event.getPath());


        if (Event.KeeperState.SyncConnected == event.getState()){
            if (event.getType() == Event.EventType.None
                    || event.getPath() == null){
                System.out.println("eventType == none or path == null");
                connectedSemaphore.countDown();
            } else if (event.getType() == Event.EventType.NodeDataChanged){
                try {
                    System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
