package com.example.react_todo_router.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.react_todo_router.dto.Todo;
import com.example.react_todo_router.mapper.TodoMapper;

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

	public void delete(int num) {
		todoMapper.delete(num);
	}

	public Todo view(int num) {
		return todoMapper.view(num);
	}

	@Transactional
	public void update(Todo todo) {
		todoMapper.update(todo);
	}

	public List<Todo> search(String word) {
		return todoMapper.search(word);
	}

}
