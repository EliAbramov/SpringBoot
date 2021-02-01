package com.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourse {

	@GetMapping("/")
	public String home() {
		return ("<h1>Wellcome</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Wellcome User</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Wellcome Admin</h1>");
	}
}
