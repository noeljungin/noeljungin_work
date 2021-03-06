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
	public void 게시글저장_불러오기테스트() {
		
		// given - 테스트 기반 환경 구축, builder의 사용법 확인
		postsRepo.save(Posts.builder().title("test title").content("test content").author("test author").build());
		
		// when - 테스트 하는 행위 선언, Posts가 DB에 insert되는 것을 확인
		List<Posts> postsList = postsRepo.findAll();
		
		// then - 테스트 결과 검증, 실제로 DB에 인서트 되었는지 확인하기 위해 조회후 입력된 값 확인
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("test title"));
		assertThat(posts.getContent(), is("test content"));
		
	}
	
	
	@Test
	public void BaseTimeEntity_등록() {
		
		LocalDateTime now = LocalDateTime.now();
		
		postsRepo.save(Posts.builder().title("test title").content("test content").author("test author").build());
		
		List<Posts> postsList = postsRepo.findAll();
		
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreateDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}







