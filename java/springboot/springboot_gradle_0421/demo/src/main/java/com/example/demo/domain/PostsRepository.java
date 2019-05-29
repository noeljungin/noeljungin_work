package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//myBatis에서는 DAO를 생성하지만 JPA에서는 Repository 라고 부르며 interface로 생성한다
//interface를 생성하고 <Entity 클래스, Primary Key 타입>을 상속하면 기본적인 CRUD 메서드를 자동성한다
public interface PostsRepository extends JpaRepository<Posts, Long>{

	
}
