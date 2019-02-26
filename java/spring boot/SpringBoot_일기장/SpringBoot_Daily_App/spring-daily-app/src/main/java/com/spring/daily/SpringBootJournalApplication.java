package com.spring.daily;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.daily.domain.Journal;
import com.spring.daily.repository.JournalRepository;

//SpringBootApplication - Configuration, EnableAutoConfiguration, ComponentScan 어노테이션을 합친 것
@SpringBootApplication
public class SpringBootJournalApplication {
	//Bean을 생성
	@Bean
	//스프링 엔진이 인스턴스 생성 후 초기화 할 때 항상 호출하는 특수 클래스
	//saveData는 스프링 시동 준비 전에 실행
	InitializingBean saveData(JournalRepository repo) {
		return () ->{
			//repo.save메서드를 통해서 자료 샘플을 입력
			repo.save(new Journal("spring boot 입문1", "스프링 공부 시작1", "15/05/2018"));
			repo.save(new Journal("spring boot 입문2", "스프링 공부 시작2", "16/05/2018"));
			repo.save(new Journal("spring boot 입문3", "스프링 공부 시작3", "17/05/2018"));
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}

}
