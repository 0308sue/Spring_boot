package com.example.react_simpleboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.react_simpleboard.model.Board;
import com.example.react_simpleboard.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("api/list")
	public List<Board> list(){
		return boardService.list();
	}
	
	@PostMapping("api/insert")
	public String insert(@RequestBody Board board) {
		boardService.insert(board);
		return "success";
	}
	
	@DeleteMapping("api/delete")
	public String delete(@PathVariable Long num) {
		boardService.delete(num);
		return "success";
	}
}
