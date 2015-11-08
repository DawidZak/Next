package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Voter  {
	@Id
	private int ID;
	protected Person voterData; //kompozycja 
	protected String partyMember;

}
