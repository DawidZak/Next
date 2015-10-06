package com.next.dzejk;



import java.util.List;
//tutaj bylo extend Serializable
public interface CandidateMethods {
	
	public List<CandidateModel> saveCandidate(CandidateModel candidate); 
	
	public List<CandidateModel> deleteCandidate(); 
	
	public List<CandidateModel>  getCandidate();
}
/*
 *http://www.mkyong.com/java-best-practices/understand-the-serialversionuid/ 
 * http://docs.spring.io/docs/Spring-MVC-step-by-step/part3.html
 * http://www.tutorialspoint.com/java/java_serialization.htm
 * http://tutorials.jenkov.com/java-generics/generic-list.html
 * http://mattfleming.com/node/134
 * */

