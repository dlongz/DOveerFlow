package com.codingdojo.dojo_overflow.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {

	// Method attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String question;
	
	@Transient
	private String frontEndTags;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-dd-MM")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-dd-MM")
	private Date updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answer;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "question_tags",
			joinColumns = @JoinColumn(name = "question_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id")
			)
	private List<Tag> tags;
	
	
	public Question() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getFrontEndTags() {
		return frontEndTags;
	}

	public void setFrontEndTags(String frontEndTags) {
		this.frontEndTags = frontEndTags;
	}
	
	
}
