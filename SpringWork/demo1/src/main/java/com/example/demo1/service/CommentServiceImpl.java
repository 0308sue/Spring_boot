package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo1.dao.BoardMapper;
import com.example.demo1.dao.CommentMapper;
import com.example.demo1.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;

	@Override
	@Transactional
	public void insert(CommentDTO comment) {
		comment.setUserid("admin90");
		cmapper.insert(comment);
		bmapper.updateReplyCnt(comment.getBnum(), 1);
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Override
	@Transactional
	public void delete(int cnum) {
		CommentDTO comment = cmapper.findByNum(cnum);
		cmapper.delete(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
	}

}
