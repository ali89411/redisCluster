package com.ccitsoft.activeMQ.Selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * <p>Description: [提供session 接口]</p>
 * Created on 2018年3月1日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 
 * Copyright (c) 2018 桑德环卫 云平台技术部
 */
public class ActiveMQConnection {

	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	
	public ActiveMQConnection() throws Exception{
		this.connectionFactory  = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				"tcp://localhost:61616");
			this.connection = this.connectionFactory.createConnection();
			connection.start();
			this.session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
	};
	
	public Session getSession(){
		return session;
	}
	
	public void closeConnection(){
		try {
			this.connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
