package org.kjs.mobile.controller;

import java.util.List;

import org.kjs.controller.HomeController;
import org.kjs.domain.TobaccoVO;
import org.kjs.service.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mobile/tobacco")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileTobaccoController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	MobileService service;
	@GetMapping(value="/list", produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<TobaccoVO>> list() {
		return new ResponseEntity<>(service.getListTobacco(), HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<TobaccoVO> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}*/
	
}
