package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean //스프링에 필요한 객체를 생성
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		/*
		 * MyBatis의 SqlSessionFactory를 반환
		 * 스프링부트가 실행할 때 DataSource 객체를 메서드 실행 시 주입해서 결과를 만들고
		 * 그 결과를 스프링내 빈으로 사용하게된
		 */
		
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
		
	}
}
