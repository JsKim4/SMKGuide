package org.kjs.mobile.controller;

import java.util.List;

import org.kjs.controller.HomeController;
import org.kjs.domain.SmokeAreaVO;
import org.kjs.service.MobileService;
import org.kjs.service.SmokeAreaService;
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

@RequestMapping("/mobile/smokearea")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileSmokeAreaController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	MobileService service;
	SmokeAreaService tempService;
	@GetMapping(value="/list", produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<SmokeAreaVO>> list() {
		return new ResponseEntity<>(tempService.listSmokeArea(), HttpStatus.OK);
	}
	
}
