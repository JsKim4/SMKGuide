package org.kjs.security;

import org.kjs.controller.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
	static PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		logger.info(rawPassword.toString());
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return rawPassword.toString().equals(encodedPassword);
	}

}
