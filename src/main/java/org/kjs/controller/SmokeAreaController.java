package org.kjs.controller;

import java.util.List;

import org.kjs.domain.SmokeAreaVO;
import org.kjs.service.SmokeAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/map")
@RestController
@Slf4j
@AllArgsConstructor
public class SmokeAreaController {
	private SmokeAreaService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value="/", produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<SmokeAreaVO>> getList(){
		return new ResponseEntity<>(service.listSmokeArea(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<SmokeAreaVO> create(@RequestBody SmokeAreaVO vo){
		service.register(vo);
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<SmokeAreaVO> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("id") Long id) {
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}
