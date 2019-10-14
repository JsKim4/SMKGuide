package org.kjs.controller;

import org.kjs.domain.ComponentPageDTO;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.service.ComponentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RequestMapping("/component")
@RestController
@Slf4j
@AllArgsConstructor
public class ComponentController {
	//Component Service로 처리
	private ComponentService service;
	
	/* 기본골자
	 * url로 들어오는 type에 따라 table을 변경 하며 insert 실행
	 * component로 묶인 table 의 구성요소는 id,name만 존재하며
	 * type,brand,country,company가 이에 속함
	 * */
	
	
	
	/*
	 * create 와 modify는
	 * requestBody로 vo를 받게 되는데 vo안에 있는 name field 만 사용함
	 * */
	@PostMapping(value = "/{type}/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ComponentVO vo, @PathVariable("type") String type) {
		vo.setType(type);
		log.info(vo.toString());
		return service.register(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/{type}/{id}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ComponentVO vo, @PathVariable("type") String type,
			@PathVariable("id") Long id) {
		vo.setType(type);
		vo.setId(id);
		return service.modify(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	/*
	 * url로 type 과 page를 받음
	 * */
	@GetMapping(value = "pages/{type}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type) {
		ComponentVO vo = new ComponentVO(type);
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<>(service.getList(vo, cri), HttpStatus.OK);
	}

	
	/*
	 * get 과  remove의 경우 url을 통해 type과 id 만 받아 처리함
	 * url로 type 과 page를 받음
	 * */
	
	@GetMapping(value = "/{type}/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentVO> get(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return new ResponseEntity<>(service.get(vo), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{type}/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return service.remove(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
