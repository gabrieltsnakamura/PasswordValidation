package com.itau.validacao_senha;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidacaoSenhaApplicationTests {

	@Autowired
	ValidacaoSenhaApplication start;
	
	@Test
	void contextLoads() {
		start.main(new String[]{});
	}

}
