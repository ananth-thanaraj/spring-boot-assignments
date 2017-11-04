package com.password.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration {
	
	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();			
	}
}
