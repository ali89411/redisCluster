package com.ccitsoft.redisCluster;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
/**
 * <p>Description: [描述该类概要功能介绍]</p>
 * Created on 2018年2月26日
 * @author  <a href="mailto: lichao8941188@163.com"></a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class TestJedis {

	private static Jedis jedis;

	public static void main(String[] args) {
		jedis = new Jedis("192.168.89.230",6379);
		String sel_user_age = "sel_user_age";
//		Map<String,String> userMap = new HashMap<String,String>();
//		// uuId1
//		String uuId_1 = UUID.randomUUID().toString();
//		userMap.put(uuId_1, JSON.toJSONString(new User(uuId_1, "lic1", 26)));
//		jedis.sadd(sel_user_age, uuId_1);
//		// uuId2
//		String uuId_2 = UUID.randomUUID().toString();
//		userMap.put(uuId_2, JSON.toJSONString(new User(uuId_2, "lic2", 27)));
//		// uuId1
//		String uuId_3 = UUID.randomUUID().toString();
//		userMap.put(uuId_3, JSON.toJSONString(new User(uuId_3, "lic3", 26)));
//		jedis.sadd(sel_user_age, uuId_3);
//		// uuId1
//		String uuId_4 = UUID.randomUUID().toString();
//		userMap.put(uuId_4, JSON.toJSONString(new User(uuId_4, "lic4", 29)));
//		// uuId1
//		String uuId_5 = UUID.randomUUID().toString();
//		userMap.put(uuId_5, JSON.toJSONString(new User(uuId_5, "lic5", 30)));
//		jedis.hmset("SYS-USER-TABLE", userMap);
		
		// select * from user where age = '26'
		// 结合set集合，初始化时分类。取得交集，也可以创建view 方式 建立条件查询
//		Map<String, String> hgetAll = jedis.hgetAll("SYS-USER-TABLE");
		Set<String> sinter = jedis.sinter("SYS-USER-TABLE",sel_user_age);
		for (String string : sinter) {
			System.out.println(jedis.hget("SYS-USER-TABLE", string));
		}
	}

}
