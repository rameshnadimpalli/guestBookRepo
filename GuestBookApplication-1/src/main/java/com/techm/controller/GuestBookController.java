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
import com.techm.service.GuestBookService;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@Controller
public class GuestBookController {
	@Autowired
	GuestBookService guestBookService;

	@RequestMapping("/showGuestbook")
	public String viewEntries(Model m) {
		List<Entry> list = guestBookService.getEntries();
		List<Entry> arlist = guestBookService.getAREntries();
		m.addAttribute("list", list);
		m.addAttribute("approvedrejectedlist", arlist);
		return "showGuestbook";
	}

	@RequestMapping(value = "/reject/{id}", method = RequestMethod.GET)
	public String reject(@PathVariable int id) {
		guestBookService.reject(id);
		return "redirect:/showGuestbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request) {
		Entry entry = new Entry();
		entry.setTextentry(request.getParameter("textentry"));
		entry.setImagepath(request.getParameter("imagepath"));
		guestBookService.save(entry);
		request.setAttribute("isAdded", "added");
		return "createEntry";
	}

	@RequestMapping(value = "/approve/{id}", method = RequestMethod.GET)
	public String approve(@PathVariable int id) {
		guestBookService.approve(id);
		return "redirect:/showGuestbook";
	}
}