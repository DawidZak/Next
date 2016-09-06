package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Voter  {
	@Id
	private int ID; 
	protected String partyMember;
	private int IDU;
}
 