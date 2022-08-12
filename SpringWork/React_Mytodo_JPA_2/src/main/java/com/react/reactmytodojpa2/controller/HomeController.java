package com.react.reactmytodojpa2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.reactmytodojpa2.model.Todo;
import com.react.reactmytodojpa2.service.TodoService;

@RequestMapping("/todo/*")
@RestController
public class HomeController {

	@Autowired
	TodoService todoService;

	@PutMapping("/insert")
	public String insert(@RequestBody Todo todo) {
		System.out.println(todo.getTitle());
		todoService.save(todo);
		return "success";
	}

	@DeleteMapping("/delete/{num}")
	public String delete(@PathVariable Long num) {
		todoService.deleteById(num);
		return "success";
	}

	@GetMapping("/find/{num}")
	public ResponseEntity<Todo> search(@PathVariable Long num) {
		Optional<Todo> todo = todoService.findById(num);
		if (todo.isPresent())
			return new ResponseEntity<Todo>(todo.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/update")
	public void update(@RequestBody Todo todo) {
		todoService.update(todo);
	}

	@GetMapping({ "/list/{title}", "/list" })
	public List<Todo> search(@PathVariable(required = false) String title) {
		if (title == null)
			return todoService.findAll();
		else
			return todoService.search(title);
	}
}
