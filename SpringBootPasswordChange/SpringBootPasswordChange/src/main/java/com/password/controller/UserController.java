package com.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.password.data.UserRepository;
import com.password.model.User;
import com.password.utils.PasswordValidator;

@RestController
@RequestMapping("/users")
public class UserController {

	boolean valid;

	@Autowired
	private UserRepository urepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PasswordValidator passValidator;


	@PostMapping("/user")
	ResponseEntity<User> addUser(@RequestBody User user){
		User usr = new User();
		valid = passValidator.validate(user.getPassword());
		if(valid == true) {
			usr.setId(user.getId());
			usr.setUsername(user.getUsername());
			usr.setPassword(passwordEncoder.encode(user.getPassword()));
			return new ResponseEntity<>(urepo.save(usr), HttpStatus.CREATED);		
		} else 
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);		

	}

	@PutMapping("/user/{id}")
	ResponseEntity<User> changePassword(@PathVariable("id") Long id, @RequestBody User user) throws Exception{
		valid = passValidator.validate(user.getPassword());
		User usr = urepo.findOne(id);
		System.out.println(usr.getPassword() + "   " + user.getPassword());
		if(valid==true && !(passwordEncoder.matches(user.getPassword(), usr.getPassword()))) {
			urepo.findAll()
			.stream()
			.filter(pwd -> Long.valueOf(id).equals(pwd.getId()))
			.forEach(pwd -> {
				pwd.setPassword(passwordEncoder.encode(user.getPassword()));
				urepo.save(pwd);			
			});
			return new ResponseEntity<>(HttpStatus.CREATED);	
		}else
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);	

	}

}
