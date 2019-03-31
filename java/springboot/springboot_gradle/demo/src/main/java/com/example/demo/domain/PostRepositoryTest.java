package com.example.demo.domain;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dto.Posts;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
	
	@Autowired
	PostsRepository postsRepo;
	
	@After
	public void cleanup() {
		postsRepo.deleteAll();
	}
	
	@Test
	public void saveBoardCall() {
		postsRepo.save(Posts.builder()
				.title("title")
				.content("content")
				.author("test")
				.build());
		
		List<Posts> postsList = postsRepo.findAll();
		
		Posts posts = postsList.get(0);
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		LocalDateTime now = LocalDateTime.now();
		postsRepo.save(Posts.builder()
				.title("title")
				.content("content")
				.author("author")
				.build());
		
		List<Posts> postsList = postsRepo.findAll();
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreateTime().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
		
		
	}

}
