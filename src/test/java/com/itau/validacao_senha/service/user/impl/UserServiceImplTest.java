package com.itau.validacao_senha.service.user.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceImplTest {

	UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	@Test
	public void validPassword() throws Exception {
		assertEquals(userServiceImpl.validateUser("AbTp9!fok"), true);
	}
	
	@Test
	public void InvalidPassword() throws Exception {
		assertEquals(userServiceImpl.validateUser("AbTp9 fok"), false);
	}
	
}
