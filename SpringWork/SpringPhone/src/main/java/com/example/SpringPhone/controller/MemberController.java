package com.example.SpringPhone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPhone.model.Member;
import com.example.SpringPhone.service.MemberService;

@RestController
@RequestMapping("member/")
public class MemberController {
	
		@Autowired
		private MemberService memberService;
		
		//전체보기
		@GetMapping("list")
		public List<Member> list(){
			return 	memberService.list();
		}
		
		//추가
		@PostMapping("insert")
		public Member insert(@RequestBody Member member) {
			return memberService.insert(member);
		}
		
		//수정
		@PutMapping("update/{id}")
		public Member update(@PathVariable Long id, @RequestBody Member member) {
			
			return memberService.update(id, member);
		}
		
		//삭제
		@DeleteMapping("delete/{id}")
		public void delete(@PathVariable Long id) {
			memberService.delete(id);
		}
}
