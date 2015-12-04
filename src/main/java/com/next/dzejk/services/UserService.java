package com.next.dzejk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.ICandidateRepository;
import com.next.dzejk.dao.IUserRepository;
import com.next.dzejk.model.User;
@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
