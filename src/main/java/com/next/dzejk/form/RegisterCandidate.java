package com.next.dzejk.form;

import com.next.dzejk.model.Person;

public class RegisterCandidate extends Person {

	private Integer ID ;
	private String Slogan;
	private Boolean partyMember;
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
	public Boolean getPartyMember() {
		return partyMember;
	}
	public void setPartyMember(Boolean partyMember) {
		this.partyMember = partyMember;
	}

}
