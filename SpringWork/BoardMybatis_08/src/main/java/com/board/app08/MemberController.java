package com.board.app08;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.MemberDTO;
import com.board.model.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;

	
	@GetMapping("join")
	public void join() {}
	
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
		int cnt = mservice.idCheck(member.getId());
		if(cnt!=0)return"fail";
		mservice.join(member);
		return "success";
	}
	
	@GetMapping("idcheck")
	@ResponseBody
	public int idcheck(String id) {		
		return mservice.idCheck(id);
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	@ResponseBody
	public String login(String id,String pass,HttpSession session) {
		String result="";
		MemberDTO member = mservice.loginCheck(id);
		if(member==null) {
			result="no";
		}else if(member.getPass().equals(pass)){
			session.setAttribute("sMember", member);
			result="success";
		}else {
			result="passError";
		}
		return result;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
	
}
