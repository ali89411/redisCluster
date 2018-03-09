package com.ccitsoft.redisCluster;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>Description: [描述该类概要功能介绍]</p>
 * Created on 2018年2月23日
 * @author  <a href="mailto: lichao8941188@163.com"</a>
 * @version 1.0 
 * Copyright (c) 2018
 */
public class TestRedis {

	private static JedisCluster jedisCluster;

	public static void main(String[] args) {
		
		// clusterNodes 集合
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		// 7001,7002,7003 为M。04属于01,S。05属于02,S。06属于03,S
		jedisClusterNode.add(new HostAndPort("192.168.100.33", 7001));
		jedisClusterNode.add(new HostAndPort("192.168.100.33", 7002));
		jedisClusterNode.add(new HostAndPort("192.168.100.33", 7003));
		jedisClusterNode.add(new HostAndPort("192.168.100.33", 7004));
		jedisClusterNode.add(new HostAndPort("192.168.100.33", 7005));
		jedisClusterNode.add(new HostAndPort("192.168.100.33", 7006));
//		jedisClusterNode.add(new HostAndPort(host, port));
		// 定义连接池
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setMaxIdle(2);
		jedisPoolConfig.setMaxWaitMillis(-1);
		jedisPoolConfig.setTestOnBorrow(true);
		// timeout 6000 maxAttempts重定向100次
		jedisCluster = new JedisCluster(jedisClusterNode,6000,100,jedisPoolConfig);
		jedisCluster.set("name", "lic");
		System.out.println(jedisCluster.set("sex", "27"));
		System.out.println(jedisCluster.get("name"));
		System.out.println(jedisCluster.get("sex"));
//		jedisClusterNode.forEach();
	}

}
