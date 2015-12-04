package com.next.dzejk.form;

import com.next.dzejk.model.User;

public class RegisterVoter {
	
	private User voterData; //kompozycja 
	private String partyMember;
	
	public User getVoterData() {
		return voterData;
	}
	public void setVoterData(User voterData) {
		this.voterData = voterData;
	}
	public String getPartyMember() {
		return partyMember;
	}
	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	}
}
