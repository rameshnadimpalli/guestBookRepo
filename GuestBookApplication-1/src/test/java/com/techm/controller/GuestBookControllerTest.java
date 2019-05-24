package com.techm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GuestBookControllerTest {
	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    
    @Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
    @Test
	 public void viewEntriesTest() throws Exception {
		//this.mockMvc.perform(get("/guestSignin")).andExpect(content().string("guestSignin"));
		 mockMvc.perform(get("/showGuestbook")).andExpect(status().isOk());
	 }


    @Test
	 public void saveTest() throws Exception {
		//this.mockMvc.perform(get("/guestSignin")).andExpect(content().string("guestSignin"));
		 mockMvc.perform(post("/save")).andExpect(status().isOk());
	 }
	
}

