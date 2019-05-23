package com.techm.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.techm.dao.LoginDao;
import com.techm.service.LoginService;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoginServiceTest {

	@InjectMocks
    private LoginService loginService;
	
	@Mock
    private LoginDao loginDao;
	
	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(loginService).isNotNull();
	  }
	  
	  @Test
	  public void showFormTest() {
	      when(loginDao.validate("guest", "dummyPass")).thenReturn("G");
		  assertEquals("G", loginService.validate("guest", "dummyPass"));
	  }
}
