package com.kjbank.blog.test;

import java.awt.print.Pageable;
import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjbank.blog.model.RoleType;
import com.kjbank.blog.model.User;
import com.kjbank.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 없습니다";
		}
		
		return "삭제 id :" + id;
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id: " + id);
		System.out.println("password: " + requestUser.getPassword());
		System.out.println("emai: " + requestUser.getEmail());		
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user);
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
//	@GetMapping("/dummy/user")
//	public List<User> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
//		Page<User> pagingUser = userRepository.findAll(pageable);
//		
//		if(pagingUser.isLast()) {
//			
//		}
//		List<User> users = pagingUser.getContent();
//		return users;
//	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 사용자가 없습니다.");
		}
		});				
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.err.println("id: " + user.getId());
		System.err.println("username: " + user.getUsername());
		System.err.println("password: " + user.getPassword());
		System.err.println("email: " + user.getEmail());
		System.err.println("role: " + user.getRole());
		System.err.println("createDate: " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완";
	}
}