package com.techm.controller;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.techm.bean.Entry;
import com.techm.dao.GuestBookDao;
import com.techm.service.GuestBookService;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GuestBookServiceTest {

	@InjectMocks
    private GuestBookService guestBookService;
	
	@Mock
    private GuestBookDao guestBookDao;
	
	@Test
	 public void savedTest() {
		 Entry p=new Entry();
		 p.setTextentry("my comments");
		 p.setImagepath("");
		 p.setStatus("P");
		 p.setId(1234);
		 when(guestBookDao.save(p)).thenReturn(1);
		 assertEquals(1, guestBookService.save(p));
	 }
	 
	@Test	 
	public void approveTest() {
		 when(guestBookDao.approve(11)).thenReturn(1);
		 assertEquals(1, guestBookService.approve(11));
	}
	 
	@Test	
	public void rejectTest() {
		 when(guestBookDao.reject(11)).thenReturn(1);
		 assertEquals(1, guestBookService.reject(11));
	}
	@Test
	public void delete() {
		 when(guestBookDao.delete(11)).thenReturn(1);
		 assertEquals(1, guestBookService.delete(11));
	}
	@Test
	public void getEntries() {
		when(guestBookDao.getEntries()).thenReturn(new ArrayList<Entry>());
		assertEquals(true, guestBookService.getEntries().isEmpty());
	}
	@Test
	public void getAREntries() {
		when(guestBookDao.getAREntries()).thenReturn(new ArrayList<Entry>());
		assertEquals(true, guestBookService.getAREntries().isEmpty());
	}	 
}