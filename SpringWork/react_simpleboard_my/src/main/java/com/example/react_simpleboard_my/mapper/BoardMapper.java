package com.example.react_simpleboard_my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.react_simpleboard_my.dto.Board;

@Mapper
public interface BoardMapper {

	@Insert("insert into simpleboard (title,content) values(#{title},#{content})")
	public void insert(Board board);
	
	@Select("select * from simpleboard")
	public List<Board> list();

	@Delete("delete from simpleboard where num = #{num}")
	public void delete(int num);

	
}
