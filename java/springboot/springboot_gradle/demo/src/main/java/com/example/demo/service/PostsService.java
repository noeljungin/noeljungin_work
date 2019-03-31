package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.PostsRepository;
import com.example.demo.dto.PostsMainResponseDto;
import com.example.demo.dto.PostsSaveRequestsDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepo;
	
	@Transactional
	public Long save(PostsSaveRequestsDto dto) {
		return postsRepo.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		return postsRepo.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
}
