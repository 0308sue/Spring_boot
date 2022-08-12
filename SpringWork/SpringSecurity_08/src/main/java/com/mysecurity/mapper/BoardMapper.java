package com.mysecurity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysecurity.dto.BoardDTO;

public interface BoardMapper {
	
	@Insert("insert into board (title,writer,content,regdate) values(#{title},#{writer},#{content},now())")
	public void insert(BoardDTO board);
	
	@Select("select * from board")
	public List<BoardDTO> list();
	
	@Select("select count(*) from board")
	public int count();
	
	@Select("select * from board where num = #{num}")
	public BoardDTO view(int num);
	
	@Update("update board set replyCnt= replyCnt+#{amount} where num=#{bnum}")
	public void updateReplyCnt(@Param("bnum") int bnum,@Param("amount") int amount);

}
