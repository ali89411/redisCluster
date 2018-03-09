package com.ccitsoft.activeMQ.Selector;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQMapMessage;

/**
 * <p>Description: [测试MessageConsumer---Selector]</p>
 * Created on 2018年3月1日
 * @author  <a href="mailto: lichao8941188@163.com"></a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class Producer {
	
		public static void main(String[] args) throws Exception{
			
			Session session = new ActiveMQConnection().getSession();
			Destination destination = session.createQueue("first1");
			MessageProducer messageProducer = session.createProducer(destination);
			
			MapMessage mapMessage1 = new ActiveMQMapMessage();
			mapMessage1.setString("name", "zhangsan");
			mapMessage1.setString("sex", "M");
			// Selector过滤
			mapMessage1.setIntProperty("age", 28);
			mapMessage1.setStringProperty("address", "beijing");
			// DeliveryMode.PERSISTENT  测试持久化
			messageProducer.send(destination, mapMessage1, DeliveryMode.PERSISTENT, 4, 1000*60*10);
			
			
			MapMessage mapMessage2 = new ActiveMQMapMessage();
			mapMessage2.setString("name", "lisi");
			mapMessage2.setString("sex", "W");
			// Selector过滤
			mapMessage2.setIntProperty("age", 28);
			mapMessage2.setStringProperty("address", "shanghai");
			messageProducer.send(destination, mapMessage2, DeliveryMode.PERSISTENT, 4, 1000*60*10);
			
			
			MapMessage mapMessage3 = new ActiveMQMapMessage();
			mapMessage3.setString("name", "wangwu");
			mapMessage3.setString("sex", "M");
			// Selector过滤
			mapMessage3.setIntProperty("age", 27);
			mapMessage3.setStringProperty("address", "shanxi");
			messageProducer.send(destination, mapMessage3, DeliveryMode.PERSISTENT, 4, 1000*60*10);
			new ActiveMQConnection().closeConnection();
		}
}
