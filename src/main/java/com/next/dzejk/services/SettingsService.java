package com.next.dzejk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.next.dzejk.dao.IUserRepository;
import com.next.dzejk.model.User;

@Service
public class SettingsService implements ISettingsService {

	@Autowired
	IUserRepository iUserRepository;

	@Override
	public User changeUserSetings(String pesel) {
		User user = iUserRepository.findByPesel(pesel);
		return user;

	}

	@Override
	public boolean saveUserSetings(User user) {
		System.out.println("kjest?" + user.getCity());
		iUserRepository.save(user);
		return false;

	}
}
