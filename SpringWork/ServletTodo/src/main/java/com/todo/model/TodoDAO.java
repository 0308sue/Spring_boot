package com.todo.model;

import java.util.ArrayList;

public interface TodoDAO {
	//추가
	public void insert(Todo todo);
	//전체보기
	public ArrayList<Todo> list();
	

}
