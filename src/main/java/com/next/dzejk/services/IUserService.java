package com.next.dzejk.services;

import com.next.dzejk.form.RegisterUser;
import com.next.dzejk.model.User;

public interface IUserService {
	
	User saveInitUser(User user);
	
	User saveUser(RegisterUser registerUser);

}
