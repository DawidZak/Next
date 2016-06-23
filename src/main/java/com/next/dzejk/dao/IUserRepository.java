package com.next.dzejk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.next.dzejk.model.User;
@Repository 
@Transactional
public interface IUserRepository  extends JpaRepository<User, Integer>  {
	@Query("SELECT u FROM User u WHERE pesel = :pesel")
	public User findByPesel(@Param("pesel")String pesel);
}
