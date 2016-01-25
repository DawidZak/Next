package com.next.dzejk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class CandidatePartyPresident extends Candidate {
	@Id
    @GeneratedValue
	private Integer ID ;
	private int IDP;
}
