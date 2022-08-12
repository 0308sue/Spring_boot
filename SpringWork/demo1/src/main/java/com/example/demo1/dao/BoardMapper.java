package com.example.demo1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo1.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	@Insert("insert into board(title,writer,content,regdate) values(#{title},#{writer},#{content},now())")
	public void insert(BoardDTO board);
	
	public List<BoardDTO> list();
	
	@Select("select * from board where num = #{num}")
	public BoardDTO findBynum(int num);
	
	@Update("update board set title=#{title},content=#{content},regdate=now() where num=#{num}")
	public void update(BoardDTO board);
	
	@Delete("delete from board where num = #{num}")
	public void delete(int num);
	
	@Select("select count(*) from board")
	public int getcount();
	
	@Update("update board set replycnt = replycnt+#{amount} where num = #{bnum}")
	public void updateReplyCnt(@Param("bnum")int bnum,@Param("amount")int amount);
}

