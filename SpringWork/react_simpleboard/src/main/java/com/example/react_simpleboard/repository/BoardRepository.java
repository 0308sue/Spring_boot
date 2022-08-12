package com.example.react_simpleboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.react_simpleboard.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
