package com.techm.bean;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
public class Entry {
	private int id;
	private String textentry;
	private String imagepath;
	private String status;

	public String getTextentry() {
		return textentry;
	}

	public void setTextentry(String textentry) {
		this.textentry = textentry;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

}