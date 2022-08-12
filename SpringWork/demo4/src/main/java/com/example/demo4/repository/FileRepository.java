package com.example.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo4.model.FileBoard;

public interface FileRepository extends JpaRepository<FileBoard, Long> {

}
