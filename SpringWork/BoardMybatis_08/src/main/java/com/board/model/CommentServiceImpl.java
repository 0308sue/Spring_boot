package com.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.dto.CommentDTO;
import com.board.mapper.BoardMapper;
import com.board.mapper.CommentMapper;
@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper cmapper;
	
	@Autowired
	private BoardMapper bmaMapper;

	@Transactional
	@Override
	public void insert(CommentDTO comment) {
		cmapper.insert(comment);
		bmaMapper.updateReplyCnt(comment.getBnum(),1);
		
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Override
	public void delete(int cnum) {
		 CommentDTO comment =  cmapper.read(cnum);
		 bmaMapper.updateReplyCnt(comment.getBnum(), -1);
		 cmapper.delete(cnum);
		
	}

}
