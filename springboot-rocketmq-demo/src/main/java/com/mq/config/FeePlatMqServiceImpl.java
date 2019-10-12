package com.mq.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanyugang
 * @description 消息发送测试
 * @date 2019-10-12 10:42
 */
@Service
public class FeePlatMqServiceImpl implements FeePlatMqService {
    @Resource
    private DefaultMQProducer defaultMQProducer;
    @Resource
    private ParamConfig paramConfig;


    @Override
    public SendResult openAccountMsg(String msgInfo){
        // 可以不使用Config中的Group
        defaultMQProducer.setProducerGroup(paramConfig.feePlatGroup);
        SendResult sendResult = null;
        try {
            Message sendMsg = new Message(paramConfig.feePlatTopic,
                    paramConfig.feeAccountTag,
                    "fee_open_account_key", msgInfo.getBytes());
            sendResult = defaultMQProducer.send(sendMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendResult ;
    }
}
