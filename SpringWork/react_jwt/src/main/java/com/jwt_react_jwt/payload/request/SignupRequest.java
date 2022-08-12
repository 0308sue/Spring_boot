package com.jwt_react_jwt.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SignupRequest {

	private String username;
	private String email;
	private String password;
	private String role;
}
