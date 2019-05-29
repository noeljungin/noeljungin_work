package com.example.demo.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepo;
	
	@After
	public void cleanup() {
		postsRepo.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		// BDD
		
		// given - 기반 환경 구축 
		postsRepo.save(Posts.builder()
				.title("title")
				.content("content")
				.author("author")
				.build());
		
		// when - 테스트 할 행위
		List<Posts> postsList = postsRepo.findAll();
		
		// then -  테스트 결과 검증
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("test title"));
		assertThat(posts.getContent(), is("test content"));
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		LocalDateTime now = LocalDateTime.now();
		postsRepo.save(Posts.builder()
				.title("title2")
				.content("content2")
				.author("author2")
				.build()
				);
		
		List<Posts> postsList = postsRepo.findAll();
		
		Posts posts = postsList.get(0);
		
		assertTrue(posts.getCreateDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
	
	
	
}
