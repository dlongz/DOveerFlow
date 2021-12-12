package com.codingdojo.dojo_overflow.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.codingdojo.dojo_overflow.models.Question;

@Component
public class TagValidator {

	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		Question ques = (Question) target;
		
		String[] tags = ques.getFrontEndTags().split(", ");
		if(tags.length > 3) {
			errors.rejectValue("frontEndTags", "3 Tags Limit", "Please adjust tags to 3 or less.");
		}
	}
}
