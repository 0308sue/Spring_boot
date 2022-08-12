package com.example.SpringPhone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringPhone.model.Member;
import com.example.SpringPhone.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	//전체보기
	public List<Member> list(){
		
		return 	memberRepository.findAll();	
	}
	
	//추가
	public Member insert(Member member) {
		memberRepository.save(member);
		return member;
	}
	
	//수정
	@Transactional
	public Member update(Long id, Member member) {
		Member m = memberRepository.findById(id).get();
		m.setName(member.getName());
		m.setAge(member.getAge());
		m.setPhone(member.getPhone());
		m.setAddress(member.getAddress());
		m.setEmail(member.getEmail());
		return m;
	}
	
	//삭제
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
}

