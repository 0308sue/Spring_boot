package com.example.react_simpleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.react_simpleboard.model.Board;
import com.example.react_simpleboard.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Board>list(){
		return boardRepository.findAll();
	}

	public void insert(Board board) {
		boardRepository.save(board);
	}

	public void delete(Long num) {
		boardRepository.deleteById(num);
	}

}
