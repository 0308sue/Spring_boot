package com.example.demo4.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.config.auth.PrincipalDetails;
import com.example.demo4.model.Board;
import com.example.demo4.model.Comment;
import com.example.demo4.model.User;
import com.example.demo4.service.CommentService;



@RequestMapping("/reply/*")
@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@PostMapping("commentInsert/{num}")
	public ResponseEntity<String> commentInsert(@PathVariable Long num,@RequestBody Comment comment,@AuthenticationPrincipal PrincipalDetails principal) {
		Board b = new Board();
		b.setNum(num);
		comment.setBoard(b);
		
//		User user = new User();
//		user.setId(1L);
//		user.setUsername("admin");
		comment.setUser(principal.getUser());
		
		commentService.commetInsert(comment);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	@GetMapping("commentList/{num}")
	public List<Comment> commentList(@PathVariable Long num){
		List<Comment> clist= commentService.commentList(num);
		return clist;
	}
	
	@DeleteMapping("delete/{cnum}")
	public Long delete(@PathVariable Long cnum) {
		commentService.delete(cnum);
		return cnum;
	}
}