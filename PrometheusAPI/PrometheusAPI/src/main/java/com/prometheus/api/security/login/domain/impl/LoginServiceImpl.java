package com.prometheus.api.security.login.domain.impl;

import com.prometheus.api.security.login.adapters.input.LoginAdapters;
import com.prometheus.api.security.login.domain.entity.User;

public class LoginServiceImpl implements LoginAdapters {

	@Override
	public User authenticate(String username, String password) {
		return null;
	}

	@Override
	public void performLogout(String acessToken) {
		
	}

	@Override
	public void verifyAcessToken(String acessToken) {
		
	}

}
