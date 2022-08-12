package com.example.demo4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo4.config.auth.PrincipalDetails;
import com.example.demo4.model.Board;
import com.example.demo4.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
		return "/board/insert";
	}
	
	@PostMapping("insert")
	public String insert(Board board,@AuthenticationPrincipal PrincipalDetails principal) {
		boardService.insert(board,principal.getUser());
		return "redirect:/board/list";
	}
	
//	@GetMapping("list")
//	public String list(Model modle,@PageableDefault(size = 3,sort = "num",direction = Direction.DESC) Pageable pagelable) {
//		Page<Board> boards = boardService.list(pagelable);
//		modle.addAttribute("boards",boards);
//		modle.addAttribute("count", boardService.count());
//		return "/board/list";
//	}
	
	@GetMapping("list")
	public String list(Model modle,
			@PageableDefault(size = 3,sort = "num",direction = Direction.DESC) Pageable pagelable,
			@RequestParam(required = false,defaultValue = "")String field,
			@RequestParam(required = false,defaultValue = "")String word) {
		Page<Board> boards = boardService.findAll(field,word,pagelable);
		Long count = boardService.count(field,word);
		modle.addAttribute("boards",boards);
		modle.addAttribute("count", count);
		return "/board/list";
	}
	
	@GetMapping("view/{num}")
	public String view (@PathVariable Long num,Model model) {
		model.addAttribute("boards", boardService.view(num));
		return "/board/view";
	}
	
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable Long num) {
		boardService.delete(num);
		return "success";
	}
	
	@GetMapping("update/{num}")
	public String update (@PathVariable Long num,Model model) {
		model.addAttribute("boards", boardService.view(num));
		return "/board/update";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.update(board);
		return "redirect:/board/list";
	}

}
