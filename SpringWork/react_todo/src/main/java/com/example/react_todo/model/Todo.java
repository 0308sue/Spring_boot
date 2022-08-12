package com.example.react_todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "todoJpa")
public class Todo {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String name;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	@CreationTimestamp
	private Date regdate;
	private String subject;
	private String summary;
}
