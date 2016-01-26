package com.next.dzejk.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AddParty {
	@NotEmpty
	private String partyName;
	@NotEmpty
	private String partyPresident;
	@NotEmpty
	private String wing;
	@NotNull @Digits(integer=10,fraction=0)
	private int countMembers;
	
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getPartyPresident() {
		return partyPresident;
	}
	public void setPartyPresident(String partyPresident) {
		this.partyPresident = partyPresident;
	}
	public String getWing() {
		return wing;
	}
	public void setWing(String wing) {
		this.wing = wing;
	}
	public int getCountMembers() {
		return countMembers;
	}
	public void setCountMembers(int countMembers) {
		this.countMembers = countMembers;
	}
	public AddParty(){};
}
