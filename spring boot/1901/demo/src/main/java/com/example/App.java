package com.example;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;

@EnableAutoConfiguration
//@Import(AppConfig.class)//JavaConfig를 읽어들이기 위해서 Impor로 Configuration 어노테이션이 붙은 클래스를 지정
@ComponentScan //클래스의 패키지 내부에 있는 모든 클래스를 검색
public class App implements CommandLineRunner{
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;
	
	@Override
	public void run(String...strings) throws Exception{
		System.out.println("Enter 2 numbers : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result : "+result);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
	
}
