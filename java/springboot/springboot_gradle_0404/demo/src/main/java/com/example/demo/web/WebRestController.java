package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostsModifyRequestDto;
import com.example.demo.dto.PostsSaveRequestDto;
import com.example.demo.service.PostsService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class WebRestController {
	
	//AllArgsConstructor를 이용여 생성자로 Bean객체를 받는다
	//private PostsRepository postsRepo;
	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello there";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
	
	@PostMapping("/posts/modify")
	public Long postsModify(@RequestBody PostsModifyRequestDto dto) {
		return postsService.modify(dto);
	}
	
	@PostMapping("/posts/delete")
	public Long postsDelete(@RequestBody Long id) {
		return postsService.delete(id);
	}
	
	

}
