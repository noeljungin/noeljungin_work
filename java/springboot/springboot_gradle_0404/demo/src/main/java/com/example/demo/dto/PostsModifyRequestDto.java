package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostsModifyRequestDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder().title(title).content(content).author(author).build();
	}

}
