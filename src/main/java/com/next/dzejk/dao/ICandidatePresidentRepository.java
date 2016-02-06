package com.next.dzejk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.next.dzejk.model.CandidatePresident;

@Repository 
@Transactional
public interface ICandidatePresidentRepository  extends JpaRepository<CandidatePresident,Integer> {

}
