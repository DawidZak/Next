package com.next.dzejk.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IRoleRepository;
import com.next.dzejk.model.Role;

@Service
public class RoleService implements IRoleService {

	@Autowired
	IRoleRepository roleRepository;
	
	@PostConstruct
	void init(){
	saveRole(new Role("User"));
	saveRole(new Role("Voter"));
	saveRole(new Role("President Candidate"));
	saveRole(new Role("Admin"));
	}
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
		 
	}

}
