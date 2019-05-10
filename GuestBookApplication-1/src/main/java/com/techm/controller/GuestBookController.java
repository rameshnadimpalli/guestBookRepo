package com.techm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techm.bean.Entry;
import com.techm.dao.GuestBookDao;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@Controller
public class GuestBookController {
	@Autowired
	GuestBookDao guestBookDao;

	@RequestMapping("/showGuestbook")
	public String viewentries(Model m) {
		List<Entry> list = guestBookDao.getEntries();
		List<Entry> arlist = guestBookDao.getAREntries();
		m.addAttribute("list", list);
		m.addAttribute("approvedrejectedlist", arlist);
		return "showGuestbook";
	}

	@RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
	public String reject(@PathVariable int id) {
		guestBookDao.reject(id);
		return "redirect:/showGuestbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request) {
		Entry entry = new Entry();
		entry.setTextentry(request.getParameter("textentry"));
		entry.setImagepath(request.getParameter("imagepath"));
		guestBookDao.save(entry);
		request.setAttribute("isAdded", "added");
		return "createEntry";
	}

	@RequestMapping(value = "/approve/{id}", method = RequestMethod.GET)
	public String approve(@PathVariable int id) {
		guestBookDao.approve(id);
		return "redirect:/showGuestbook";
	}
}