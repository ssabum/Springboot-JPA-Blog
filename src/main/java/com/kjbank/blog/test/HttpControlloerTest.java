package com.kjbank.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

@RestController
public class HttpControlloerTest {
	
	private static final String TAG="HttpControllerTest: ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ss").password("1234").email("q@q.com").build();
		System.out.println(TAG + "getter: " + m.getUsername());
		m.setUsername("ss");
		System.out.println(TAG + "setter: " + m.getUsername());
		return "lombok 테스트 완";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete";
	}
}
