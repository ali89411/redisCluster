package com.ccitsoft.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * <p>Description: [activeMQ--sender]</p>
 * Created on 2018年2月27日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 
 * Copyright (c) 2018 桑德环卫 云平台技术部
 */
public class Sender {
	
	public static void main(String[] args) throws Exception{
		// 1,建立工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				"tcp://localhost:61616");
		// 2,创建connection,打开连接
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// 3,创建session---参数1,是否持久化，2,签收模式--一般设置为自动签收。
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 4,创建目标地址
		Destination destination = session.createQueue("queue1");
		// 5,创建发送者DeliveryMode是否持久化。TimeToLive存活的时间。Priority消息优先级,参数1-9  默认是4  5-9是加急。
		MessageProducer messageProducer = session.createProducer(destination);
//		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//		messageProducer.setTimeToLive(100000);
//		messageProducer.setPriority(5);
		// 6,创建消息
		for(int i = 0;i < 5; i++){
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("第"+i+"发送文本！！！-----lic");
//			messageProducer.send(textMessage);
			// 参数1. 消息  参数2. 是否是否持久化  3.优先级 参数1-9  默认是4  5-9是加急。4.存活的时间
		    messageProducer.send(textMessage, DeliveryMode.NON_PERSISTENT, i, 1000*60*2);
		}
		// 使用事务时候------必须提交
		// session.commit();
		if(connection != null){
			connection.close();
		}
	}

}
