package com.techm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.bean.Entry;
import com.techm.dao.GuestBookDao;

@Service
public class GuestBookService {
	
	private final GuestBookDao guestBookDao;
	
	@Autowired
	public GuestBookService(GuestBookDao guestBookDao){
		this.guestBookDao=guestBookDao;
	}
	
	public int save(Entry p) {
		return guestBookDao.save(p);
	}
	
	public int approve(int id) {
		return guestBookDao.approve(id);
	}
	
	public int reject(int id) {
		return guestBookDao.reject(id);
	}
	
	public int delete(int id) {
		return guestBookDao.delete(id);
	}
	
	public List<Entry> getEntries() {
		return guestBookDao.getEntries();
	}
	
	public List<Entry> getAREntries() {
		return guestBookDao.getAREntries();
	}
	
	
}
