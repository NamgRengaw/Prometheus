package com.prometheus.api.security.login.adapters.input;

import com.prometheus.api.security.login.domain.entity.User;

public interface LoginAdapters {

	public User authenticate(String username, String password);
	
	public void performLogout(String acessToken);
	
	public void verifyAcessToken(String acessToken);
	
}
