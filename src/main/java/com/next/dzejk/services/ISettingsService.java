package com.next.dzejk.services;

import com.next.dzejk.model.User;

public interface ISettingsService {

	User changeUserSetings(String pesel);

	boolean saveUserSetings(User user);

}
