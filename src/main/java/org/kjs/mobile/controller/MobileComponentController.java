package org.kjs.mobile.controller;

import java.util.List;

import org.kjs.domain.ComponentVO;
import org.kjs.service.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mobile/component")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileComponentController {
	private static final Logger logger = LoggerFactory.getLogger(MobileTobaccoController.class);
	MobileService service;
	@GetMapping(value="/list/{type}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ComponentVO>> list(@PathVariable String type) {
		return new ResponseEntity<>(service.getListComponent(new ComponentVO(type)), HttpStatus.OK);
	}
	
	
}
