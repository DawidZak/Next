package com.next.dzejk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.next.dzejk.model.CandidatePartyPresident;
@Repository
@Transactional
public interface ICandidatePartyPresidentRepository extends JpaRepository<CandidatePartyPresident,Integer> {

}
