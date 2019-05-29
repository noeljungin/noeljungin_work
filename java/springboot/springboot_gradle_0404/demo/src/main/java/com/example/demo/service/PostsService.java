package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.PostsRepository;
import com.example.demo.dto.PostsMainResponseDto;
import com.example.demo.dto.PostsModifyRequestDto;
import com.example.demo.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepo;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepo.save(dto.toEntity()).getId();
	}
	
	//list
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		return postsRepo.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
	
	//1개 호출
	@Transactional(readOnly = true)
	public PostsInfoResponseDto findPosts(Long id) {
		return postsRepo.findById(id).map(PostsInfoResponseDto::new).get();
	}
	
	//수정
	@Transactional
	public Long modify(PostsModifyRequestDto dto) {
		if(postsRepo.existsById(dto.getId()))
		{
			postsRepo.modify(dto.getTitle(), dto.getContent(), dto.getAuthor(), dto.getId());
		}
		return dto.getId();
	}
	
	@Transactional
	public Long delete(Long id) {
		if(postsRepo.existsById(id)) 
		{
			postsRepo.deleteById(id);
		}
		
		return id;
	}
	
}
