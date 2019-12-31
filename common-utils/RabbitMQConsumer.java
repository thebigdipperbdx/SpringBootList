package com.sto.baisong.order.consumer.rabbitmq;

import com.sto.baisong.order.consumer.service.BaiSongOrderSendRecordService;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMQConsumer {
	private static final Logger LOGGER = Logger.getLogger(RabbitMQConsumer.class);

	public static final String BAISONG_ORDER_QUEUE = "queue_name";
	public static final String BAISONG_ORDER_EXCHANGE = "exchange_name";
	public static final String BAISONG_ORDER_KEY = "RoutingKey";

	private String addresses;
	private String username;
	private String password;
	private Boolean publisherConfirms;
	private String virtualHost;

	@Autowired
	private BaiSongOrderSendRecordService baiSongOrderSendRecordService;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(addresses);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setPublisherConfirms(publisherConfirms);
		connectionFactory.setVirtualHost(virtualHost);
		return connectionFactory;
	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}

	@Bean
	public DirectExchange baiSongDirectExchange() {
		return new DirectExchange(BAISONG_ORDER_EXCHANGE, true, false);
	}

	@Bean
	public Queue baiSongQueue() {
		return new Queue(BAISONG_ORDER_QUEUE, true);
	}

	@Bean
	public Binding baiSongBindingExchange(Queue baiSongQueue, DirectExchange baiSongDirectExchange) {
		return BindingBuilder.bind(baiSongQueue).to(baiSongDirectExchange).with(BAISONG_ORDER_KEY);
	}

	@Bean
	public SimpleMessageListenerContainer baiSongOrderMessageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
		container.setQueues(baiSongQueue());
		container.setExposeListenerChannel(true);
		container.setPrefetchCount(20);// 每次只消费20条
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
		container.setConcurrentConsumers(40);//最小消费者实例数
        container.setMaxConcurrentConsumers(40);//最大消费者实例数
		container.setMessageListener(new ChannelAwareMessageListener() {
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				byte[] body = message.getBody();
				String bodyStr = new String(body);
				try {
					LOGGER.info("正在推送佰颂快递订单数据,消息内容:" + bodyStr);
					baiSongOrderSendRecordService.saveBaiSongOrderSendRecord(bodyStr);
					LOGGER.info("佰颂快递订单数据推送完成,消息内容:" + bodyStr);
				} catch (Exception e) {
					LOGGER.error("佰颂快递订单数据推送失败,消息内容:" + bodyStr, e);
				} finally {
					// 确认消费成功
					channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
				}
			}
		});
		return container;
	}

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
