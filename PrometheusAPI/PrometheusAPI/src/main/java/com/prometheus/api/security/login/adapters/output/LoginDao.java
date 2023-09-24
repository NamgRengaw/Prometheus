package com.prometheus.api.security.login.adapters.output;

import com.prometheus.api.security.login.domain.entity.User;

public interface LoginDao {

	void saveUser(User user);
	
	User findUserByUsername(String username);
	
}
