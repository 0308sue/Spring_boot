package com.example.demo3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo3.model.JpaMember;
import com.example.demo3.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public void save(JpaMember member) {
		memberRepository.save(member);
	}
	
	public List<JpaMember> list(){
		return memberRepository.findAll();
	}
	
	public Page<JpaMember> list(Pageable pageable){
		return memberRepository.findAll(pageable);
	}
	
	public JpaMember detail(Long id) {
		return memberRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	@Transactional
	public void update(JpaMember member) {
		JpaMember m = memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setName(member.getName());
		m.setPassword(member.getPassword());
	}
}
