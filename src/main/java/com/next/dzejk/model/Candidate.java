package com.next.dzejk.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


//Rozszerzam klase CandidateModel o klase PersonModel
/*
 * 
 */

@Entity
public class Candidate extends Person   {

	
	/**
	 * 
	 */

	@Id
    @GeneratedValue
	private Integer ID ;
//	public Candidate();
//	public Candidate(Integer iD, String slogan, Boolean partyMember) {
//		super();
//		this.ID = iD;
//		this.Slogan = slogan;
//		this.partyMember = partyMember;
//	}
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
		return "Candidate [ID=" + ID + ", Slogan=" + Slogan
				+ ", partyMember=" + partyMember + ", Name=" + Name
				+ ", Surename=" + Surename + ", Age=" + Age + ", bornDate="
				+ bornDate + "]";
	}
	
	
		
	}

	
	

	

	
	//http://docs.oracle.com/javase/tutorial/java/IandI/override.html
	

