package com.atashgah.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atashgah.demo.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

	
	
}
