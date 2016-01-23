package com.next.dzejk.model;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;


//Rozszerzam klase CandidateModel o klase PersonModel
/*
 * 
 */
@MappedSuperclass
public class Candidate  {
	protected String firstName;
	protected String lastName;
	protected String Slogan;
	protected String partyMember;
	protected int IDU;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSlogan() {
		return Slogan;
	}
	public void setSlogan(String slogan) {
		Slogan = slogan;
	}
	public int getIDU() {
		return IDU;
	}
	public void setIDU(int iDU) {
		IDU = iDU;
	}
	public String getPartyMember() {
		return partyMember;
	}
	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	} 
	}

	
	
   
	

	
	//http://docs.oracle.com/javase/tutorial/java/IandI/override.html
	

