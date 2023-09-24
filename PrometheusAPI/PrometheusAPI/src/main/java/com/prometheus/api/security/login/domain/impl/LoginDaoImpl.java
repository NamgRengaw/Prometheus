package com.prometheus.api.security.login.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.prometheus.api.security.login.adapters.output.LoginDao;
import com.prometheus.api.security.login.controllers.repositoryJpa.UserRepository;
import com.prometheus.api.security.login.domain.entity.User;

public class LoginDaoImpl implements LoginDao {

	private UserRepository userRepository;
	
	@Autowired
	public LoginDaoImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

}
