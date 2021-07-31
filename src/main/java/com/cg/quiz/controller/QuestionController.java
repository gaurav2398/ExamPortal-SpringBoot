package com.cg.quiz.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.quiz.entity.exam.Question;
import com.cg.quiz.entity.exam.Quiz;
import com.cg.quiz.service.QuestionService;
import com.cg.quiz.service.QuizService;

@CrossOrigin("*")
@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	// add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}

	// update question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}

	// get question of quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {
//		Quiz quiz = new Quiz();
//		quiz.setqId(qid);
//		Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//		return ResponseEntity.ok(questionOfQuiz);

		Quiz quiz = this.quizService.getQuizes(qid);
		Set<Question> questions = quiz.getQuestions();

		List<Question> list = new ArrayList(questions);
		if (questions.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
				
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}

	// get question of quiz
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
		Quiz quiz = new Quiz();
		quiz.setqId(qid);
		Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionOfQuiz);

	}

	// get single question by id
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}

	// delete question
	@DeleteMapping("/{quesId}")
	public void deleteQuiz(@PathVariable("quesId") Long qid) {
		this.questionService.deleteQuestion(qid);
	}

	double marksGot = 0;
	int correctAnswers = 0;
	int attempted = 0;
	

	// eval quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> question) {

		// single questions
		System.out.println(question);
		for(Question q : question){

//			Question ques = this.questionService.get(q.getQuesId());

			if (q.getAnswer().trim().equals(q.getGivenAnswer().trim())) {
				// correct
				correctAnswers++;
				double marksSingle = Double.parseDouble(question.get(0).getQuiz().getMaxMarks()) / question.size();
				marksGot += marksSingle;

			}
			if (!(q.getGivenAnswer() == null || q.getGivenAnswer().trim().equals(""))) {
				attempted++;
			}
		}
		Map<String,Object> map = new HashMap<String, Object>() {{
	        put("marksGot", marksGot);
	        put("correctAnswers", correctAnswers);
	        put("attempted", attempted);
	    }};
//		Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
		return ResponseEntity.ok(map);
	}

}
