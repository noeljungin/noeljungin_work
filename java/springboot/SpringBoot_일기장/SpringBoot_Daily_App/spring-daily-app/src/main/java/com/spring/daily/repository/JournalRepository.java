package com.spring.daily.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.daily.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}
