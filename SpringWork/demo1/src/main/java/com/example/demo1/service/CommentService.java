package com.example.demo1.service;

import java.util.List;

import com.example.demo1.dto.CommentDTO;

public interface CommentService {

	public void insert(CommentDTO comment);
	
	public List<CommentDTO> getList(int bnum);
	
	public void delete(int cnum);
}
