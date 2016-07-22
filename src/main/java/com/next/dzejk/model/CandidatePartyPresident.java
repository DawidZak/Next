package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class CandidatePartyPresident extends Candidate {
	@Id
    @GeneratedValue
	private Integer ID ;
	private int IDP;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public int getIDP() {
		return IDP;
	}
	public void setIDP(int iDP) {
		IDP = iDP;
	}
}
