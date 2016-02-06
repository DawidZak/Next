package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class PoliticalParty {
	@Id
	@GeneratedValue
	private int ID;
	private  String partyName;
	private int countMembers;
	private String kind;
	private String partyPresident;
	private String candidatePresident;
	public PoliticalParty(){};
	public PoliticalParty(int ID,String partyName, int countMembers, String kind, String partyPresident) {
		super();
		this.ID=ID;
		this.partyName = partyName;
		this.countMembers = countMembers;
		this.kind = kind;
		this.partyPresident = partyPresident;
	}


}
