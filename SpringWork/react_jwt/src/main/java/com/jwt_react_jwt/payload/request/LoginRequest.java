package com.jwt_react_jwt.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {

	private String username;
	private String password;
}
