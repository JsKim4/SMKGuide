package org.kjs.security;

import org.kjs.controller.HomeController;
import org.kjs.domain.CustomUser;
import org.kjs.domain.MemberVO;
import org.kjs.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;

public class CustomUserDetailService implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Setter(onMethod_= {@Autowired})
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = mapper.get(username);
		CustomUser user = new  CustomUser(vo);
		return vo==null ? null:user;
	}

}
