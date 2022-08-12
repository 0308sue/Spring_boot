package com.example.demo5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo5.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByUsername(String username);
	
	public void deleteById(Long id);
	
	Page<Member> findByUsernameContaining(String word,Pageable pageable);
	
	@Query(value = "select count(*) from tbl_member5 where username like CONCAT('%',:word,'%')",nativeQuery = true)
	public Long cntSearch (@Param("word") String word);
}
