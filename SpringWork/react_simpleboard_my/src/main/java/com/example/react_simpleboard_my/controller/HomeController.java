package com.example.react_simpleboard_my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.react_simpleboard_my.dto.Board;
import com.example.react_simpleboard_my.service.BoardService;

@RestController
public class HomeController {
	@Autowired
	private BoardService boardService;

	@GetMapping("api/test")
	public String test() {
		System.out.println("test");
		return "success";
	}	
	
	@PostMapping("api/insert")
	public String insert(@RequestBody Board board) {
		boardService.insert(board);
		System.out.println("insert");
		return "success";
	}
	
	@GetMapping("api/list")
	public List<Board> list() {
		return  boardService.list();
	}
	
	@DeleteMapping("api/delete/{num}")
	public String delete(@PathVariable int num) {
		System.out.println(num);
		boardService.delete(num);
		return "success";
	}
}
