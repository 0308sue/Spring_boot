package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.dao.BoardMapper;
import com.example.demo1.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bmapper;

	@Override
	public void insert(BoardDTO board) {
		bmapper.insert(board);
		
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return bmapper.list();
	}

	@Override
	public BoardDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return bmapper.findBynum(num);
	}

	@Override
	public void update(BoardDTO board) {
		bmapper.update(board);
		
	}

	@Override
	public void delete(int num) {
		bmapper.delete(num);
		
	}

	@Override
	public int getcount() {
		return bmapper.getcount();
	}
	
	

}
