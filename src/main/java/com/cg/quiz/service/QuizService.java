package com.cg.quiz.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.cg.quiz.entity.exam.Category;
import com.cg.quiz.entity.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);

	public Set<Quiz> getQuizes();

	public Quiz getQuizes(Long quizId);
	
	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizesOfCategory(Category category);

	public List<Quiz> getActiveQuizes();
	
	public List<Quiz> getActiveQuizesOfCategory(Category category);
	
	
	
}
