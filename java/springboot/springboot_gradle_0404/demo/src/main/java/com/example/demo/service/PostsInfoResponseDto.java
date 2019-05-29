package com.example.demo.service;

import com.example.demo.dto.Posts;

import lombok.Getter;

@Getter
public class PostsInfoResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	
	public PostsInfoResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		content = entity.getContent();
		author = entity.getAuthor();
	}

}
