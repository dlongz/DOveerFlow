package com.codingdojo.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo_overflow.models.Question;
import com.codingdojo.dojo_overflow.models.Tag;
import com.codingdojo.dojo_overflow.repositories.QuestionRepository;
import com.codingdojo.dojo_overflow.repositories.TagRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;

	@Autowired
	private TagRepository tRepo;

	public List<Question> getAllQuestions() {
		return this.qRepo.findAll();
	}

	public Tag getATag(String string) {
		return this.tRepo.findBySubject(string);
	}
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsQues = new ArrayList<>();
		String[] tagProcess = tags.split(", ");
		for (String s : tagProcess) {
			if(this.tRepo.existsBySubject(s)) {
				Tag addTag = this.getATag(s);
				tagsQues.add(addTag);
			} else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsQues.add(this.getATag(s));
			}
		}

		return tagsQues;
	}

	//C.R.U.D.
	public Question createQues(Question ques) {
		ques.setTags(this.splitTags(ques.getFrontEndTags()));
		return this.qRepo.save(ques);
	}

	public Question findQues(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}

	public Question updateQues(Question ques) {
		return this.qRepo.save(ques);
	}

	public void deleteQues(Long id) {
		this.deleteQues(id);
	}
}
