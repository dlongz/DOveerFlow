package com.codingdojo.dojo_overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo_overflow.models.Answer;
import com.codingdojo.dojo_overflow.models.Question;
import com.codingdojo.dojo_overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository aRepo;
	
	@Autowired
	private QuestionService qServ;
	
	public List<Answer> getAllAnswers(){
		return this.aRepo.findAll();
	}
	
	
	//C.R.U.D.
	public Answer createAns(Answer ans) {
		return this.aRepo.save(ans);
	}
	
	public void addAnsToQuestion(Answer answer, Question ques) {
		List<Answer> ansPool = ques.getAnswers();
		ansPool.add(answer);
		this.aRepo.save(answer);
	}
	public Answer findAns(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	public Answer updateAns(Answer ans) {
		return this.aRepo.save(ans);
	}
	
	public void deleteAns(Long id) {
		this.aRepo.deleteById(id);
	}
	
}
