package com.next.dzejk.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


//Rozszerzam klase CandidateModel o klase PersonModel
/*
 * 
 */

@Entity
public class Candidate extends Person implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
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
	@Override
	public String toString() {
		return "CandidateModel [ID=" + ID + ", Slogan=" + Slogan
				+ ", partyMember=" + partyMember + ", Name=" + Name
				+ ", Surename=" + Surename + ", Age=" + Age + ", bornDate="
				+ bornDate + "]";
	}
	
	
		
	}

	
	

	

	
	//http://docs.oracle.com/javase/tutorial/java/IandI/override.html
	

