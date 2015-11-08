package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
@Data
@Entity
public class PoliticalParty {
	@Id
	private int ID;
	private String partyName;
	private int countMembers;
	private String kind;
	private String partyPresident;
	


}
