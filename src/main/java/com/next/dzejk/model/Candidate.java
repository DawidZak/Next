package com.next.dzejk.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;


//Rozszerzam klase CandidateModel o klase PersonModel
/*
 * 
 */
@Data
@Entity
public class Candidate    {
	@Id
    @GeneratedValue
	private Integer ID ;
	private String Slogan;
	private Boolean partyMember;
	private int IDU; 
	}

	
	
   
	

	
	//http://docs.oracle.com/javase/tutorial/java/IandI/override.html
	

