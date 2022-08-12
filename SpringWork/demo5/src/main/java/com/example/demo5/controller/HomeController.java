package com.example.demo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo5.model.Member;
import com.example.demo5.repository.MemberRepository;
import com.example.demo5.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	@Autowired 
	private MemberService memberService;
	
	private final MemberRepository memberRepository;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error",required = false)String error) {
		return "/login";
	}

	
	@GetMapping("register")
	public String register() {
		return "/join";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody Member member) {
		if(memberRepository.findByUsername(member.getUsername())!=null) {
			return "fail";
		}
		memberService.register(member);
		return "success";
	}
	
	@GetMapping("list")
	public String list(Model modle,
			@PageableDefault(size = 3,sort = "id",direction = Direction.DESC) Pageable pagelable,
			@RequestParam(required = false,defaultValue = "")String word) {
		Page<Member> members = memberService.findAll(word,pagelable);
		Long count = memberService.count(word);
		modle.addAttribute("members",members);
		modle.addAttribute("count", count);
		return "/list";
	}
	
	@GetMapping("view/{id}")
	public String view (@PathVariable Long id,Model model) {
		model.addAttribute("members", memberService.view(id));
		return "view";
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		memberService.delete(id);
		return "success";
	}
	
	@GetMapping("update/{id}")
	public String update (@PathVariable Long id,Model model) {
		model.addAttribute("members", memberService.view(id));
		return "/update";
	}
	
	@PostMapping("update")
	public String update(Member member) {
		memberService.update(member);
		return "redirect:/logout";
	}

}
