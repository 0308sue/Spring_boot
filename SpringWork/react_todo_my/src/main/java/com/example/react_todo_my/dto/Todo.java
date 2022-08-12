package com.example.react_todo_my.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Todo {
	private Long num;
	private String name;
	private Date regdte;
	private String subject;
	private String summary;

}
