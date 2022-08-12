package com.mysecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysecurity.dto.CommentDTO;
import com.mysecurity.mapper.BoardMapper;
import com.mysecurity.mapper.CommentMapper;


@Service
public class CommentService {

	@Autowired
	private CommentMapper cmapper;
	
	@Autowired
	private BoardMapper bmaMapper;

	@Transactional
	public void insert(CommentDTO comment) {
		cmapper.insert(comment);
		bmaMapper.updateReplyCnt(comment.getBnum(),1);
		
	}

	public List<CommentDTO> getList(int num) {
		return cmapper.getList(num);
	}

	@Transactional
	public void delete(int cnum) {
		 CommentDTO comment =  cmapper.read(cnum);
		 bmaMapper.updateReplyCnt(comment.getBnum(), -1);
		 cmapper.delete(cnum);
		
	}

}
