package com.ccitsoft.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * <p>Description: [activeMQ消费者]</p>
 * Created on 2018年2月28日
 * @author  <a href="mailto: lichao8941188@163.com"></a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Receive {

	public static void main(String[] args) throws Exception{
		    // 1,建立工厂
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,
					"tcp://localhost:61616");
			// 2,创建connection,打开连接
			Connection connection = connectionFactory.createConnection();
			connection.start();
			// 3,创建session---参数1,是否开启事务，2,接受的方式
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			// 4,创建目标地址
			Destination destination = session.createQueue("queue1");
			// 5,创建发送者
			MessageConsumer consumer = session.createConsumer(destination);
			String messageSelector = null;
			session.createConsumer(destination, messageSelector);
			while (true) {
				Message receive = (TextMessage)consumer.receive();
//				receive.acknowledge();----Session.CLIENT_ACKNOWLEDGE
				System.out.println(receive);
			}
	}

}
