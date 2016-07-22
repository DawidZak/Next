package com.next.dzejk.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public class PoliticalParty {
	@Id
	@GeneratedValue
	private int ID;
	private  String partyName;
	private int countMembers;
	private String kind;
	@OneToOne(cascade=CascadeType.ALL)
	private User userPartyPresident;
	private String candidatePresident;
	public PoliticalParty(){};
	public PoliticalParty(int ID,String partyName, int countMembers, String kind, User userPartyPresident) {
		super();
		this.ID=ID;
		this.partyName = partyName;
		this.countMembers = countMembers;
		this.kind = kind;
		this.userPartyPresident = userPartyPresident;
	}
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
	public String getCandidatePresident() {
		return candidatePresident;
	}
	public void setCandidatePresident(String candidatePresident) {
		this.candidatePresident = candidatePresident;
	}
	public User getUserPartyPresident() {
		return userPartyPresident;
	}
	public void setUserPartyPresident(User userPartyPresident) {
		this.userPartyPresident = userPartyPresident;
	}


}
