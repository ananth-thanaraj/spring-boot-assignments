package com.password.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordValidator {
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

	  public PasswordValidator(){
		  pattern = Pattern.compile(PASSWORD_PATTERN);
	  }

	   public boolean validate(final String password){

		  matcher = pattern.matcher(password);
		  return matcher.matches();

	  }
}
