package com.next.dzejk.model;

public class Voter  {
	
	protected Person voterData; //kompozycja 
	protected String partyMember;
	
	public int vote() {
		//TODO:voting
		
		return 1;
	}
	
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
