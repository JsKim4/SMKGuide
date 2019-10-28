package org.kjs.controller;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;
import org.kjs.service.TobaccoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mobile/tobacco")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileTobaccoController {
	TobaccoService service;
	@PostMapping(value="/list", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<TobaccoVO>> list(@RequestBody Criteria cri) {
		cri.setStartIndex();
		int total = service.getTotalCount(cri);
		return new ResponseEntity<>(service.getList(cri), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<TobaccoVO> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
}
