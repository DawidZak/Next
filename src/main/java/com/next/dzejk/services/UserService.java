package com.next.dzejk.services;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IUserRepository;
import com.next.dzejk.form.RegisterUser;
import com.next.dzejk.model.Region;
import com.next.dzejk.model.User;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User saveInitUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User saveUser(RegisterUser registerUser) {
		int i = 0;
		// String hashedPassword=null;
		String login = registerUser.getPESEL();
		String password = registerUser.getPassword();
		System.out.println(password);
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// hashedPassword = passwordEncoder.encode(password);
		// String hashedLogin = passwordEncoder.encode(login);
		// System.out.println(hashedPassword);
		i++;

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(registerUser.getPassword());
		String hashedPESEL = passwordEncoder.encode(registerUser.getPESEL());
		Region region = new Region();
		region.setId(registerUser.getIdD());
		User user = new User();
		user.setFirstName(registerUser.getFirstName());
		user.setLastName(registerUser.getLastName());
		user.setCity(registerUser.getCity());
		user.setPassword(hashedPassword);
		user.setRegion(region);
		user.setEmail(registerUser.getEmail());
		user.setPESEL(registerUser.getPESEL());
		user.setIdR(1);
		return userRepository.save(user);
	}

	@PostConstruct
	void init() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("12");
		saveInitUser(new User("Imie1", "Nazwisko1", hashedPassword, "12", "wp.pl", "Lodz", 4));

	}

	@Override
	public User updateUser(String pesel) {
		Session sess = sessionFactory.openSession();

		return null;
	}

}
