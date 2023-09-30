package com.prometheus.api.security.login.controllers.controllerDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prometheus.api.security.login.domain.entity.User;

@Repository
public interface UserControllerDao extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
