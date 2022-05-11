package com.kjbank.blog.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjbank.blog.model.User;

@RestController
public class UserApiController {
	
	@PostMapping("/api/user")
	public int save(@RequestBody User user) {
		System.out.println("UserApiController: save 호출");
		return 1;
	}

}
