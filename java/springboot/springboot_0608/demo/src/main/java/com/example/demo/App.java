package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import(AppConfig.class)
public class App {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter 2 numbers");
			
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			Calculator calculator = context.getBean(Calculator.class);
			int result = calculator.calc(a, b);
			System.out.println("result" + result);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
