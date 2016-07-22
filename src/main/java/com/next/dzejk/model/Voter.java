package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Voter  {
	@Id
	private int ID; 
	protected String partyMember;
	private int IDU;
}
 