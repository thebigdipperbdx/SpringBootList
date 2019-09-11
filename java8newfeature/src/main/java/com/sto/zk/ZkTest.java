package com.sto.zk;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-11 15:24
 */
public class ZkTest {
    public static void main(String[] args){
        String connect_addr="127.0.0.1:2181";
        // 建立连接
        ZkClient zkc=new ZkClient(new ZkConnection(connect_addr), 10000);
        // 创建节点
//        zkc.create("/super", "1234", CreateMode.PERSISTENT);
//        zkc.create("/super/c1", "c1内容", CreateMode.PERSISTENT);
//        zkc.create("/super/c2", "c2内容", CreateMode.PERSISTENT);

        //读取节点的值
        Object data=zkc.readData("/super");
        System.out.println(data);

        // 判断节点是否存在
        boolean flg = zkc.exists("/super/c2");
        //返回 true表示节点存在 ，false表示不存在
        System.out.println(flg);

        //删除单独一个节点，返回true表示成功
        boolean e1 = zkc.delete("/super/c2");
        //删除含有子节点的节点
        boolean e2 = zkc.deleteRecursive("/super");


    }
}
