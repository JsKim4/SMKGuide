package org.kjs.mobile.controller;

import org.kjs.controller.HomeController;
import org.kjs.domain.MemberVO;
import org.kjs.service.MemberService;
import org.kjs.service.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mobile")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileController {
	private MobileService service;
	private MemberService mservice;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@PostMapping(value = "/login", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> getToken(@RequestBody MemberVO vo) {
		String token = service.getToken(vo);
		return token != null && token.length()>0 ? new ResponseEntity<>(token, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/userInfo", consumes = "application/json",  produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<MemberVO> getVO(@RequestBody MemberVO member) {
		logger.info(""+member);
		MemberVO vo = service.getMemberByToken(member.getToken());
		return vo != null ? new ResponseEntity<>(vo, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/member/register", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> register(@RequestBody MemberVO vo) {
		mservice.join(vo);
		return true ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
