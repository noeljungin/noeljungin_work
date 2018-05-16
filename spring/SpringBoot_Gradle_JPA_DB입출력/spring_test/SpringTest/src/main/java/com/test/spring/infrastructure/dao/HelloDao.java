package com.test.spring.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.spring.domain.model.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer> {

}
