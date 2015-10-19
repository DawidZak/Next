package com.next.dzejk.form;

import com.next.dzejk.model.Person;

public class RegisterVoter {
	
	private Person voterData; //kompozycja 
	private String partyMember;
	
	public Person getVoterData() {
		return voterData;
	}
	public void setVoterData(Person voterData) {
		this.voterData = voterData;
	}
	public String getPartyMember() {
		return partyMember;
	}
	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	}
}
