package com.cg.quiz.service;

import java.util.Set;

import com.cg.quiz.entity.exam.Question;
import com.cg.quiz.entity.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long quesId);

	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);
	
	public Question get(Long questionId);
}
