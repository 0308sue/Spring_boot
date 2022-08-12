package com.react.reactmytodojpa2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.reactmytodojpa2.model.Todo;
import com.react.reactmytodojpa2.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public void save(Todo todo) {
		todoRepository.save(todo);
	}

	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public void deleteById(Long num) {
		todoRepository.deleteById(num);
	}

	public Optional<Todo> findById(Long num) {
		return todoRepository.findById(num);
	}

	@Transactional
	public void update(Todo todo) {
		Todo persist = todoRepository.findById(todo.getNum()).get();
		persist.setTitle(todo.getTitle());
		persist.setContent(todo.getContent());

	}

	public List<Todo> search(String title) {
		return todoRepository.findByTitleContaining(title);
	}
}
