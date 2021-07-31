package com.cg.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.quiz.entity.exam.Category;
import com.cg.quiz.entity.exam.Quiz;

public interface QuizRepository  extends JpaRepository<Quiz, Long>{

	public List<Quiz> findByCategory(Category category);

	//if status is active = true
	public List<Quiz> findByActive(Boolean b);
	
	
	public List<Quiz> findByCategoryAndActive(Category category,Boolean b);
}
