package com.jwt_react_jwt.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt_react_jwt.model.User;

public class UserDetailsImpl implements UserDetails {
	
	private Long id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private String role;
	
	public UserDetailsImpl(Long id,String username,String email,String password,String role) {
	 this.id=id;
	 this.username = username;
	 this.email=email;
	 this.password=password;
	 this.role=role;
	}
	public static UserDetailsImpl build(User user) {
		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return role;
			}
		});
		return collect;
	}
	
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	public String getRole() {
		return role;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
