package com.buider.test1;

import org.junit.Test;

public class UserBuilderTest2 {
	@Test
	public void builderTest2() {
		User user = User.builder()
				.name("ȫ�浹")
				.age(20)
				.build();
		System.out.println(user);
		
	}

}
