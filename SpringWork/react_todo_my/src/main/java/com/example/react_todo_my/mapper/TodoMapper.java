package com.example.react_todo_my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.react_todo_my.dto.Todo;

@Mapper
public interface TodoMapper {

	@Insert("insert into todo (name,subject,summary) values(#{name},#{subject},#{summary})")
	public void insert(Todo todo);

	@Select("select * from todo")
	public List<Todo> list();

	@Delete("delete from todo where num = #{num}")
	public void delete(Long num);

}
