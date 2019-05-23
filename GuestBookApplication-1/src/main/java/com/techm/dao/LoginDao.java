package com.techm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@Repository
public class LoginDao {
	@Autowired
	JdbcTemplate templateLogin;

	public void setTemplateLogin(JdbcTemplate templateLogin) {
		this.templateLogin = templateLogin;
	}

	public String validate(String username, String password) {
		String sql = "select usertype from users where username = '" + username + "'  and password =  '"+password+"' ";
		String username1 = "";
		try {
			username1 =  templateLogin.queryForObject(sql, String.class);
		} catch (Exception r) {
			username1 = "DNE";
		}
		return username1;
	}
}
