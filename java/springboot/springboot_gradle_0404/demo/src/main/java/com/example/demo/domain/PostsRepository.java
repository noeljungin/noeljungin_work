package com.example.demo.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>{
	@Query("SELECT p " +
			"FROM Posts p " +
			"ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();
	
	@Modifying
	@Query("UPDATE Posts p "
			+ "SET p.title = ?1, "
			+ "p.content = ?2, "
			+ "p.author = ?3 "
			+ "WHERE p.id = ?4 ")
	void modify(String title, String content, String author, Long id);
}
