package com.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.board.dto.BoardDTO;

public interface BoardMapper {
	
@Insert("insert into board (title,writer,content,regdate) values(#{title},#{writer},#{content},now())")
public void insert(BoardDTO board);

//@Select("select * from board")
public List<BoardDTO> findAll(HashMap<String, Object> hm);

@Select("select * from board where num = #{num}")
public BoardDTO findByNum(int num);

@Update ("update board set title=#{title},content=#{content},regdate=now() where num=#{num}")
public void update(BoardDTO board);

@Delete("delete from board where num = #{num}")
public void delete(int num);

//@Select("select count(*) from board")
public int getCount(HashMap<String, Object> hm);

@Update("update board set hitcount = hitcount+1 where num = #{num}")
public void upReadCount(int num);



public void updateReplyCnt(@Param("bnum") int bnum,@Param("amount") int amount);
}

