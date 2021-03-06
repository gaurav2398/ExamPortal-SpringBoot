package com.cg.quiz.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.quiz.entity.exam.Question;
import com.cg.quiz.entity.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	Set<Question> findByQuiz(Quiz quiz);

}
