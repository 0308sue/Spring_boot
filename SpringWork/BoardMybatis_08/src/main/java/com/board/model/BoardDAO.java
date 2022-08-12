package com.board.model;

import java.util.HashMap;
import java.util.List;

import com.board.dto.BoardDTO;

public interface BoardDAO {
	public void dao_insert(BoardDTO board);
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm);
	public BoardDTO dao_findByNum(int num);
	public void dao_update(BoardDTO board);
	public void dao_delete(int num);
	public int dao_getCount(HashMap<String, Object> hm);
	public void dao_upReadCount(int num);

}
