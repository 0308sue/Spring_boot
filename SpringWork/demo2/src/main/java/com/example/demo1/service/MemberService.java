package com.example.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo1.domain.CustomUser;
import com.example.demo1.dto.MemberDTO;
import com.example.demo1.mapper.MemberMapper;

@Service
public class MemberService implements UserDetailsService{

	@Autowired
	private MemberMapper mmapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		MemberDTO member = mmapper.read(username);
		return member== null?null:new CustomUser(member);
	}

}
