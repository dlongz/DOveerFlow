package com.codingdojo.dojo_overflow.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.codingdojo.dojo_overflow.models.Tag;
import com.codingdojo.dojo_overflow.repositories.TagRepository;

@Service
@Validated
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	
	//Validate Tags
	
	void validateTags(@Valid Tag tag) {
		
	}
	
	
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	//C.R.U.D
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	public Tag findTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	public Tag updateTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	public void deleteTag(Long id) {
		this.tRepo.deleteById(id);
	}
}
