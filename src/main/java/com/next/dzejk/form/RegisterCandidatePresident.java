package com.next.dzejk.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterCandidatePresident extends AbstractRegister {

	// protected Integer ID ;
	protected String Slogan;
	@NotEmpty
	protected String partyName;
	@NotNull
	@Digits(integer = 3, fraction = 0)
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

	public int getID() {
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

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

}
