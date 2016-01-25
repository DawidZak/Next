package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;

import lombok.Data;
import lombok.Getter;
@Data
@Entity
@NamedQuery(name = "saveCandidateById", query = "UPDATE PoliticalParty p SET p.candidatePresident = ?1 WHERE p.ID = ?2")
public class PoliticalParty {
	@Id
	private int ID;
	private  String partyName;
	private int countMembers;
	private String kind;
	private String partyPresident;
	private String candidatePresident;
	public PoliticalParty(){};
	public PoliticalParty(String partyName, int countMembers, String kind, String partyPresident) {
		super();
		
		this.partyName = partyName;
		this.countMembers = countMembers;
		this.kind = kind;
		this.partyPresident = partyPresident;
	}


}
