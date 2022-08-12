package com.example.demo4.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo4.model.Board;
import com.example.demo4.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Modifying
	@Query(value="insert into tbl_comment4(content,regdate,bnum,user_id)values(?1,now(),?2,?3)",nativeQuery = true)
	public void commentInsert(String content,Long bnum,Long user_id);
	
	@Query("select sc from tbl_comment4 sc where bnum=?1")
//	@Query("select sc from tbl_comment4 sc join fetch sc.board where bnum=?1")
	public List<Comment> findbyBnum(Long bnum);
	

	
}
