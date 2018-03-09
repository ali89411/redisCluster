package com.ccitsoft.activeMQ.Selector;

import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

/**
 * <p>Description: [测试MessageConsumer---Selector]</p>
 * Created on 2018年3月1日
 * @author  <a href="mailto: lichao8941188@163.com">李超</a>
 * @version 1.0 
 * Copyright (c) 2018 桑德环卫 云平台技术部
 */
public class Consumer {
	// 设置消费的条件
	static String selector1 = "age = 28";
	// 设置消费的条件
	static String selector2 = "age = 28 and address = 'beijing'";
	public static void main(String[] args) throws Exception{
		Session session =  new ActiveMQConnection().getSession();
		Destination destination = session.createQueue("first1");
		MessageConsumer messageConsumer = session.createConsumer(destination, selector1);
		
		while (true) {
			MapMessage receive = (MapMessage)messageConsumer.receive();
			System.out.println(receive);
			System.out.println(receive.getString("name"));
		}
		
	}

}
