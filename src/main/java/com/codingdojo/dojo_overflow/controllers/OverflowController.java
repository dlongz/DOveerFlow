package com.codingdojo.dojo_overflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojo_overflow.models.Question;
import com.codingdojo.dojo_overflow.services.AnswerService;
import com.codingdojo.dojo_overflow.services.QuestionService;
import com.codingdojo.dojo_overflow.services.TagService;
import com.codingdojo.dojo_overflow.validators.TagValidator;

@Controller
public class OverflowController {

	@Autowired
	private QuestionService qServ;

	@Autowired
	private AnswerService aServ;

	@Autowired
	private TagService tServ;

	@Autowired
	private TagValidator validator;

	@GetMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("ques", this.qServ.getAllQuestions());
		return "dashboard.jsp";
	}

	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("questionForm") Question question) {
		return "questionForm.jsp";
	}

	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("questionForm") Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "questionForm.jsp";
		} else {
			this.qServ.createQues(question);
			return "redirect:/questions";
		}
	}
}
