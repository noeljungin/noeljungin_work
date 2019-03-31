package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.PostsRepository;
import com.example.demo.dto.PostsSaveRequestsDto;
import com.example.demo.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsRepository postsRepo;
	
	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		
		return "hello world";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestsDto dto) {
		return postsService.save(dto);
	}
}
