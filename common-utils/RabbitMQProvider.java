package com.sto.baisong.order.provider.config;

import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
@ConfigurationProperties(prefix="spring.rabbitmq")
public class RabbitMQProvider implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback{

    private static final Logger LOGGER = Logger.getLogger(RabbitMQProvider.class);

	public static final String BAISONG_ORDER_QUEUE = "queue_name";
	public static final String BAISONG_ORDER_EXCHANGE = "exchange_name";
	public static final String BAISONG_ORDER_KEY = "RoutingKey";
    
	private RabbitTemplate rabbitTemplate;
	private Gson gson = new Gson();

    @Autowired
    public RabbitMQProvider(RabbitTemplate rabbitTemplate) {
    	this.rabbitTemplate = rabbitTemplate;
		rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容  
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            LOGGER.error("消息发送失败, 失败内容为:" + correlationData.getId());
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        LOGGER.error("发送消息到队列失败，响应编码" + replyCode + ";响应内容:" + replyText + "失败信息: 【 " + message + " 】");
    }
    
    public void sendMessge(Map<String, Object> paramsMap){
    	CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());  
        rabbitTemplate.convertAndSend(BAISONG_ORDER_EXCHANGE, BAISONG_ORDER_KEY, gson.toJson(paramsMap), correlationId);
    }

    private String addresses;
    private String username;
    private String password;
    private Boolean publisherConfirms;
    private String virtualHost;

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPublisherConfirms() {
        return publisherConfirms;
    }

    public void setPublisherConfirms(Boolean publisherConfirms) {
        this.publisherConfirms = publisherConfirms;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }
}
