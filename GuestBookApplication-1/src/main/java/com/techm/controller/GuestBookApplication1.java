package com.techm.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.techm" })
public class GuestBookApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(GuestBookApplication1.class, args);
	}
}
