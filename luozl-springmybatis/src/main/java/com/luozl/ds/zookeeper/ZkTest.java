package com.luozl.ds.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZkTest {
    private static final String CONNECT_STRING="127.0.0.1:2181";
    private static final int SESSOIN_TIEOUT=3000;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Watcher allChangeWatcher=new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("**watcher receive WatchedEvent** changed path: "+event.getPath()+
                        "; changed type: "+event.getType().name());
            }
        };
        ZooKeeper zooKeeper=new ZooKeeper(CONNECT_STRING,SESSOIN_TIEOUT,allChangeWatcher);
        zooKeeper.create("/zktest1","zktestvalue1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("Create new node zktest1");
        Stat beforeStat= zooKeeper.exists("/zktest1",true);
        System.out.println("Stat of 'zktest1' before change:"+beforeStat.toString());
    }
}
