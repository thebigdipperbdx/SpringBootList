package com.sto.zk;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.util.Collections;
import java.util.List;

/**
 * @author yanyugang
 * @description
 * ZooKeeper 分布式锁原理：临时有序节点
 * 1、创建永久性锁节点
 * 2、在锁节点下创建临时节点
 * 3、只有当前节点是锁节点下的最小节点，则获取锁成功
 * @date 2019-09-11 15:24
 */
public class ZkTest {
    private static final String LOCK_ROOT_PATH="/money/lock";
    private static final String LOCK_NODE_NAME="Lock_";

    public static void main(String[] args){
        String connect_addr="127.0.0.1:2181";
        // 建立连接
        ZkClient zkc=new ZkClient(new ZkConnection(connect_addr), 10000);
        // 创建永久性锁节点
        boolean flg=zkc.exists(LOCK_ROOT_PATH);
        if (!flg){
            // 创建永久性锁节点
            zkc.createPersistent(LOCK_ROOT_PATH, true);
        }

        List<String> list;
        for (int i=0; i < 10; i++) {
            // 临时有序节点
            // 创建EPHEMERAL_SEQUENTIAL类型节点
            String lockPath=zkc.create(LOCK_ROOT_PATH + "/" + LOCK_NODE_NAME,
                    Thread.currentThread().getName().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(lockPath);
        }
        list=zkc.getChildren(LOCK_ROOT_PATH);
        Collections.sort(list);
        System.out.println("最小节点值==================>" + list.get(0));

    }
}
