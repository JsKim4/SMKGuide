package org.kjs.controller;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.InfoVO;
import org.kjs.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/info")
@RestController
@Slf4j
@AllArgsConstructor
public class InfoRestController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//Info Service�� ó��
	private InfoService service;
	@Secured({"ROLE_ADMIN","ROLE_MANAGE"})
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody InfoVO vo) {
		service.register(vo);
		logger.info(vo.toString()+"what");
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	@Secured({"ROLE_ADMIN"})
	@PutMapping(value = "/{id}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody InfoVO vo,
			@PathVariable("id") Long id) {
		vo.setInfoId(id);
		return service.modify(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<InfoVO> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping(value = "/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("id") Long id) {
		return service.remove(id) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/list", produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE } )
	public ResponseEntity<List<InfoVO>> list(@RequestBody Criteria cri) {
		cri.setStartIndex();
		return new ResponseEntity<>(service.getList(cri), HttpStatus.OK);
	}

}
