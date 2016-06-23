package com.next.dzejk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IUserRepository;
import com.next.dzejk.model.User;

@Service
public class SetingsService implements ISetingsService {

	@Autowired
	IUserRepository iUserRepository;
	
	@Override
	public void changeUserSetings(String pesel){
		System.out.println("PESEL przed" + pesel);
		User user = iUserRepository.findByPesel(pesel);
		System.out.println("Pobrany pesel" + user.getPESEL());
		
	}
}
