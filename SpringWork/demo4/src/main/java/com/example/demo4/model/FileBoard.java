package com.example.demo4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class FileBoard {
	
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int num;
	 private String title;
	 private String writer;
	 private String content;
	 @Transient
	 private MultipartFile upload;
	 private String fileimage;
}
