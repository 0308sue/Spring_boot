package com.example.demo1.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

	private int cnum;
	private String userid;
	private String content;
	@JsonFormat(shape=Shape.STRING,pattern = "yyyy-MM-dd", timezone = "Asoa/Seoul")
	private Date regdate;
	private int bnum;
	
}
