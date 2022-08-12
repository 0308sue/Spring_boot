package com.example.react_simpleboard_my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.react_simpleboard_my.dto.Board;
import com.example.react_simpleboard_my.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper bmapper;
	
	public void insert(Board board) {
		bmapper.insert(board);
	}

	public List<Board> list() {
		return bmapper.list();
	}

	public void delete(int num) {
		bmapper.delete(num);
	}

}
