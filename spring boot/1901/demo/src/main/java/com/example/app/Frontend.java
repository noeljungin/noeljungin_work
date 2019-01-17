package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//App Class에 구현한 처리를 정리할Class
@Component
public class Frontend {
	
	//Calculator와 ArgumentResolver를 Frontend클래스에 주입
	@Autowired //DI컨테이너가 주입해야 할 필드
	ArgumentResolver argumentResolver;
	
	@Autowired
	Calculator calculator;
	
	public void run() {
		System.out.println("enter 2 numbers like 'a b : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result : "+result);
	}
}
