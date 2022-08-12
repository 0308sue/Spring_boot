package com.board.app08;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.CommentDTO;
import com.board.dto.MemberDTO;
import com.board.model.CommentService;

@RequestMapping("/reply/*")
@RestController
public class CommentController {

	@Autowired 
	private CommentService cservice;

	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment,HttpSession session) {
		String id = ((MemberDTO)session.getAttribute("sMember")).getId();
		comment.setUserid(id);
		cservice.insert(comment);
		return "success";
	}
	
	@GetMapping("commentList")
	public List<CommentDTO> list(int bnum) {
		return cservice.getList(bnum);
	}
	
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}

}
