package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PoliticalParty {
	@Id
	private int ID;
	private String partyName;
	private int countMembers;
	private String kind;
	private String partyPresident;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public int getCountMembers() {
		return countMembers;
	}
	public void setCountMembers(int countMembers) {
		this.countMembers = countMembers;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getPartyPresident() {
		return partyPresident;
	}
	public void setPartyPresident(String partyPresident) {
		this.partyPresident = partyPresident;
	}

}
