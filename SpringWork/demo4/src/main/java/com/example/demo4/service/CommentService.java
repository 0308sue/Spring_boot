package com.example.demo4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo4.model.Board;
import com.example.demo4.model.Comment;
import com.example.demo4.repository.BoardRepository;
import com.example.demo4.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final BoardRepository boardRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Transactional
	public void commetInsert(Comment comment) {
		Board b = boardRepository.findById(comment.getBoard().getNum()).get();
		b.setReplycnt(b.getReplycnt()+1);
		//commentRepository.save(comment);
		commentRepository.commentInsert(
				comment.getContent(),
				comment.getBoard().getNum(),
				comment.getUser().getId());
	}
	
	public List<Comment> commentList(Long bnum){
		return commentRepository.findbyBnum(bnum);
	}
	
	@Transactional
	public void delete(Long cnum) {
		commentRepository.deleteById(cnum);
	}

}
