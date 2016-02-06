package com.next.dzejk.model;
import javax.persistence.MappedSuperclass;


//Rozszerzam klase CandidateModel o klase PersonModel
/*
 * 
 */
@MappedSuperclass
//@Entity
public abstract class Candidate  {
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
	

