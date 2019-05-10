package com.techm.controller;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.techm.dao.LoginDao;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
public class LoginControllerTest {

	@Autowired
    private LoginController LoginController;
	
	@MockBean
    private LoginDao loginDao;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(LoginController).isNotNull();
	  }
}
