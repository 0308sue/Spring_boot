package com.buider.test;

import org.junit.Test;

public class UserBuilderTest {

	@Test
	public void builderTest() {
		User user = User.builder()
				.name("È«±æµ¹")
				.age(20)
				.build();
		System.out.println(user);
		
		User user1 = User.builder()
				.age(33)
				.name("È«±æ¼ø")
				.build();
		System.out.println(user1);
	}
}
