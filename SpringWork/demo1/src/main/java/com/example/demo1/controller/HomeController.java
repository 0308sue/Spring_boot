package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo1.dto.BoardDTO;
import com.example.demo1.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired
	private BoardService bservice;

	@GetMapping("/")
	public String home() {
		return "insert";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}

	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("boards", bservice.list());
		model.addAttribute("count", bservice.getcount());
		return "list";
	}
	
	@GetMapping("view/{num}")
	public String view(@PathVariable int num,Model model) {
		model.addAttribute("board", bservice.findByNum(num));
		return "view";
	}
	
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		bservice.delete(num);
		return "success";
	}
	
	@GetMapping("update/{num}")
	public String update(@PathVariable int num,Model model) {
		model.addAttribute("board", bservice.findByNum(num));
		return "update";
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {
		bservice.update(board);
		return "success";
	}
}
