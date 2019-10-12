package com.mq.config;

import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author yanyugang
 * @description
 * @date 2019-10-12 10:45
 */
public interface FeePlatMqService {
    SendResult openAccountMsg(String msgInfo);
}
