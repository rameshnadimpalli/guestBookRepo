package com.techm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	public LoginDao loginDao;

	public String validate(String username, String password) {
		return loginDao.validate(username, password);
	}
}
