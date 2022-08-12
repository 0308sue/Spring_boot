package com.jwt_react_jwt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name="userjwtdb")
public class User {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	private String role;
	
	public User() {
		
	}
	public User(String username,String email,String password) {
		this.username = username;
		this.email = email;
		this.password =password;
	}
}
