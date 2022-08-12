package com.mysecurity.app08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysecurity.dto.CommentDTO;
import com.mysecurity.service.CommentService;


@RequestMapping("/reply/*")
@RestController
public class CommentController {

	@Autowired 
	private CommentService cservice;
	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment) {
		cservice.insert(comment);
		return "success";
	}
	
	@GetMapping("commentList/{num}")
	public List<CommentDTO> list(@PathVariable int num) {
		return cservice.getList(num);
	}
	
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}
}
