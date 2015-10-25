package com.next.dzejk.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.next.dzejk.model.Candidate;
//tutaj bylo extend Serializable
//IRS

public interface ICandidateService {
	
	
	public Candidate saveCandidate(Candidate candidate); 
	
//	public List<Candidate> deleteCandidate(int id); 
//	
//	public List<Candidate>  getCandidate(int id);
}
/*
 *http://www.mkyong.com/java-best-practices/understand-the-serialversionuid/ 
 * http://docs.spring.io/docs/Spring-MVC-step-by-step/part3.html
 * http://www.tutorialspoint.com/java/java_serialization.htm
 * http://tutorials.jenkov.com/java-generics/generic-list.html
 * http://mattfleming.com/node/134
 * */

