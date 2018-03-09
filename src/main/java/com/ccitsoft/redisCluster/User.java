package com.ccitsoft.redisCluster;

public class User {
	
	private String id;
	
	private String name;
	
	private int sex;

	public User(){
		
	}
	
	public User(String id,String name, int sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
