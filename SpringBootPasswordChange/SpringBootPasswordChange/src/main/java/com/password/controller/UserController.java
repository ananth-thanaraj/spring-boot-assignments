package com.password.controller;

import java.util.Optional;
import java.util.function.Consumer;

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
import com.password.exception.ExceptionHandlingController;
import com.password.exception.HandleException;
import com.password.model.User;
import com.password.utils.PasswordValidator;

@RestController
@RequestMapping("/users")
public class UserController {

	boolean valid;

	HandleException he= null;

	@Autowired
	private UserRepository urepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PasswordValidator passValidator;

	@PostMapping("/user")
	ResponseEntity<String> addUser(@RequestBody User user) throws Exception{
	
			User usr = new User();
			valid = passValidator.validate(user.getPassword());		
			if(valid == true) {
				usr.setId(user.getId());
				usr.setUsername(user.getUsername());
				usr.setPassword(passwordEncoder.encode(user.getPassword()));
				urepo.save(usr);
				return new ResponseEntity<>("New User has been added to the system", HttpStatus.CREATED);		
			} else 
				he = new HandleException();
				he.throwpasswordMatchException();
				return new ResponseEntity<>(null);		
			}


	@PutMapping("/user/{id}")
	ResponseEntity<String> changePassword(@PathVariable("id") Long id, @RequestBody User user) throws Exception{
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
			return new ResponseEntity<>("Password of the user has been changed",HttpStatus.CREATED);	
		}else
			he = new HandleException();
			he.throwpasswordMatchException();
		return new ResponseEntity<String>(null);
	}

}
