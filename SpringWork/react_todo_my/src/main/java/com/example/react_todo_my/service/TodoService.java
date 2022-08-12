package com.example.react_todo_my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.react_todo_my.dto.Todo;
import com.example.react_todo_my.mapper.TodoMapper;

@Service
public class TodoService {
	
	@Autowired
	private TodoMapper todoMapper;

	public void insert(Todo todo) {
		todoMapper.insert(todo);
	}

	public List<Todo> list() {
		return todoMapper.list();
	}

	public void delete(Long num) {
		todoMapper.delete(num);
	}

}
