package com.sms.teacher_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Telephone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int no;

	//JsonIgnore to stop recurtion
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
