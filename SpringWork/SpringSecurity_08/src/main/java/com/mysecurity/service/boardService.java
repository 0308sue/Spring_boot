package com.mysecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysecurity.dto.BoardDTO;
import com.mysecurity.mapper.BoardMapper;

@Service
public class boardService {
	
	@Autowired
	private BoardMapper bmapper;

	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}
	
	public List<BoardDTO> list(){
		return bmapper.list();
	}
	
	public int count() {
		return bmapper.count();
	}
	
	public BoardDTO view(int num) {
		return bmapper.view(num);
	}

}
