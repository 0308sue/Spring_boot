package com.example.demo1.service;

import java.util.List;

import com.example.demo1.dto.BoardDTO;

public interface BoardService {
	public void insert(BoardDTO board);
	
	public List<BoardDTO> list();
	
	public BoardDTO findByNum(int num);
	
	public void update(BoardDTO board);
	
	public void delete(int num);
	
	public int getcount();
	

}
