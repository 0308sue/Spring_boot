package com.buider.test;

public class UserBuilder {
	private String name;
	private int age;
	
	public User build() {
		User user = new User();
		user.setName(this.name);
		user.setAge(this.age);
		return user;
	}
	
	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}
	public UserBuilder age(int age) {
		this.age = age;
		return this;
	}
}
