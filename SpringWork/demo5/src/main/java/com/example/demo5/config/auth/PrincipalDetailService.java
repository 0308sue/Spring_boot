package com.example.demo5.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo5.model.Member;
import com.example.demo5.repository.MemberRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	@Autowired
	private MemberRepository memberRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username);
		
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		PrincipalDetails pmember = new PrincipalDetails(member);
		return pmember;
	}

}
