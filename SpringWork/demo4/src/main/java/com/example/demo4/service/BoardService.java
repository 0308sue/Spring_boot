package com.example.demo4.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo4.model.Board;
import com.example.demo4.model.User;
import com.example.demo4.repository.BoardRepository;

@Transactional(readOnly = true)
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void insert(Board board,User user) {
		board.setUser(user);
		boardRepository.save(board);
	}
	public Page<Board> findAll(String field,String word,Pageable pageable){
//		Page<Board> boards = boardRepository.findAll(pageable);
//		if(field.equals("title")) {
//			boards = boardRepository.findByTitleContaining(word,pageable);
//		}else if(field.equals("content")) {
//			boards = boardRepository.findByContentContaining(word,pageable);
//		}
//		return boards;
		if(field.equals("title"))
			return boardRepository.findByTitleContaining(word,pageable);
		
		if(field.equals("content"))
			boardRepository.findByTitleContaining(word,pageable);
		
		return boardRepository.findAll(pageable);
	}
	
	public Page<Board> list(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	public Long count() {
		return boardRepository.count();
	}
	
	public Long count(String field,String word) {
		if(field.equals("title"))
			return boardRepository.cntTitleSearch(word);
		if(field.equals("content"))
			return boardRepository.cntContentSearch(word);
		return boardRepository.count();
	}
	
	@Transactional
	public Board view(Long num) {
		Board board = boardRepository.findById(num).get();
		board.setHitcount(board.getHitcount()+1);
		return board;
		
	}
	
	@Transactional
	public void delete(Long num) {
		//boardRepository.deleteById(num);
		boardRepository.deleteByNum(num);
	}
	
	@Transactional
	public void update(Board board) {
		Board b = boardRepository.findById(board.getNum()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());
		b.setRegdate(new Date());
	}
}
