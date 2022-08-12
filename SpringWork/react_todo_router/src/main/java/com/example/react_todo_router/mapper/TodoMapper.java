package com.example.react_todo_router.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.react_todo_router.dto.Todo;

@Mapper
public interface TodoMapper {

	@Insert("insert into todorouter (title,content) values(#{title},#{content})")
	public void insert(Todo todo);

	@Select("select * from todorouter")
	public List<Todo> list();

	@Delete("delete from todorouter where num = #{num}")
	public void delete(int num);

	@Select("select * from todorouter where num = #{num}")
	public Todo view(int num);

	@Update ("update todorouter set title=#{title},content=#{content} where num=#{num}")
	public void update(Todo todo);

	@Select("select * from todorouter where title like CONCAT('%',#{word},'%')")
	public List<Todo> search(String word);

}
