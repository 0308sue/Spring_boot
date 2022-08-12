package com.example.demo5.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo5.model.Member;
import com.example.demo5.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void register(Member member) {
		String rawPassword = member.getPassword();
		String encPassword = encoder.encode(rawPassword);
		member.setPassword(encPassword);
		member.setRole("ROLE_USER");
		
		memberRepository.save(member);
	}
	
	public Page<Member> findAll(String word,Pageable pageable){
		if(!word.isEmpty())
			return memberRepository.findByUsernameContaining(word, pageable);
		return memberRepository.findAll(pageable);
	}
	
	public Long count(String word) {
		if(!word.isEmpty())
			return memberRepository.cntSearch(word);
		return memberRepository.count();
	}
	
	public Member view(Long id) {
		Member member = memberRepository.findById(id).get();
		return member;
	}
	
	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	@Transactional
	public void update(Member member) {
		Member m = memberRepository.findById(member.getId()).get();
		m.setEmail(member.getEmail());
		m.setUsername(member.getUsername());
		m.setRegdate(new Date());
	}

}
