package com.jwt_react_jwt.payload.response;

public class JwtResponse {
	private String token;
	private String type="Bearer";
	private Long id;
	private String username;
	private String email;
	private String password;
	private String role;
	
	public JwtResponse(String accessToken,Long id,String uername,String email,String role) {
		this.token =accessToken;
		this.id = id;
		this.username = uername;
		this.email = email;
		this.role = role;
	}
	
	public String getAccessToken() {
		return token;
	}
	public void setAccessToken(String accessToken) {
		token = accessToken;
	}
	public String getTokenType() {
		return type;
	}
	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
