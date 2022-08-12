package com.mysecurity.app08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysecurity.dto.BoardDTO;
import com.mysecurity.service.boardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private boardService bservice;

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public void insert() {
		
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board){
		bservice.insert(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("boards",bservice.list());
		model.addAttribute("count",bservice.count());
		
	}
	
	@GetMapping("view/{num}")
	public String view(@PathVariable int num,Model model) {
		model.addAttribute("board",bservice.view(num));
		return "/board/view";
	}

	
}
