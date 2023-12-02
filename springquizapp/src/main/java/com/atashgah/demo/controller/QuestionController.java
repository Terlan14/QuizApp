package com.atashgah.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atashgah.demo.model.Question;
import com.atashgah.demo.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController implements ErrorController{
	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getQuestions() {
		return questionService.getAllQuestions();
	}
	@GetMapping("/{aid}")
	public ResponseEntity<Question> getQuestion(@PathVariable int aid) {
		return questionService.getQuestion(aid);
	}
	@GetMapping("/category/{category}")
	public ResponseEntity <List<Question>>getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		 
		 return questionService.addQuestion(question);
	}
	@DeleteMapping("/delete/{aid}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int aid) {
		return questionService.deleteQuestion(aid);
	}
	@PutMapping("/update")
	public ResponseEntity< String> updateOrSaveQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
}
