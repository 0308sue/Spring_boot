package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dto.CommentDTO;
import com.example.demo1.service.CommentService;

@RequestMapping("/reply/*")
@RestController
public class CommentController {

	@Autowired
	private CommentService cserviec;
	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment) {
		cserviec.insert(comment);
		return"success";
	}
	
	@GetMapping("commentList")
	public List<CommentDTO> commentList(int bnum){		
		return cserviec.getList(bnum);
	}
	
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cserviec.delete(cnum);
		return cnum;
	}
	
	
	
	
}
