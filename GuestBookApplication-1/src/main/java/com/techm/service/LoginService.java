package com.techm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.dao.LoginDao;

@Service
public class LoginService {
	
	private final LoginDao loginDao;
	
	@Autowired
	public LoginService(LoginDao loginDao) {
		this.loginDao=loginDao;
	}

	public String validate(String username, String password) {
		return loginDao.validate(username, password);
	}
}
