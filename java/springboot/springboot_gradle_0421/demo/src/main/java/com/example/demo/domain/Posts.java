package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 자동 추가
@Getter //모든 필드의 Geteer 메서드 자동 생성
@Entity
public class Posts extends BaseTimeEntity{ //DB의 테이블과 매칭될 Entity 클래스
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Primary Key 생성규칙
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false) //테이블 컬럼
	private String content;
	
	private String author;
	
	@Builder //클래스의 빌더패턴 클래스를 생성
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

}
