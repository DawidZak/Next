package com.next.dzejk.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.next.dzejk.model.User;

import lombok.Data;


public class RegisterCandidate extends RegisterUser {

	protected Integer ID ;
	protected String Slogan;
	@NotEmpty
	protected String partyMember;
	@NotNull @Digits(integer=3,fraction=0)
	protected int age;
	@NotEmpty
	protected String degree;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getSlogan() {
		return Slogan;
	}
	public void setSlogan(String slogan) {
		Slogan = slogan;
	}
	public String getPartyMember() {
		return partyMember;
	}
	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	}
	
}
