package com.itau.validacao_senha.service.user.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.itau.validacao_senha.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public boolean validateUser(String password) {
		
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()\\-+])(?!.*(.).*\\1.*).{8,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

}
