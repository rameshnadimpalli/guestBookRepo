package com.techm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techm.bean.*;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@Repository
public class LoginDao {
	@Autowired
	JdbcTemplate templatelogin;

	public void setTemplatelogin(JdbcTemplate templatelogin) {
		this.templatelogin = templatelogin;
	}

	public String validate(String username, String password) {
		String sql = "select usertype from users where username = '" + username + "'  and password =  '"+password+"' ";
		String username1 = "";
		try {
			username1 = (String) templatelogin.queryForObject(sql, String.class);
		} catch (Exception r) {
			username1 = "DNE";
		}
		return username1;
	}
}
