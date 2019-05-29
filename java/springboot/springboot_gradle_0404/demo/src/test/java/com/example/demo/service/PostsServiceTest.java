package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.PostsRepository;
import com.example.demo.dto.Posts;
import com.example.demo.dto.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepo;
	
	@After
	public void cleanup() {
		postsRepo.deleteAll();
	}
	
	@Test
	public void Dto데이터가_posts테이블에_저장된다() {
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.title("test title")
				.content("test content")
				.author("test author")
				.build();
		postsService.save(dto);
		
		Posts posts = postsRepo.findAll().get(0);
		
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		
	}

}
