package com.example.app;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data //컴파일 할 때 setter getter toString equals hashcode 메서드 생성
@RequiredArgsConstructor //롬복
//인자 객체를 표현하는데 사용할 클래스
public class Argument {
	private final int a;
	private final int b;
}
