package com.next.dzejk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.next.dzejk.model.Candidate;

@Repository //RR
@Transactional
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
		

}
