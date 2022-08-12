package com.board.model;

import java.util.List;

import com.board.dto.CommentDTO;

public interface CommentService {
public void insert(CommentDTO comment);
public List<CommentDTO> getList(int bnum);
public void delete(int cnum);

}
