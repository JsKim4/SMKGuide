package org.kjs.controller;

import org.kjs.domain.ComponentVO;
import org.kjs.service.ComponentService;
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

@RequestMapping("/component")
@RestController
@Slf4j
@AllArgsConstructor
public class ComponentRestController {
	//Component Service�� ó��
	private ComponentService service;
	
	/* �⺻����
	 * url�� ������ type�� ���� table�� ���� �ϸ� insert ����
	 * component�� ���� table �� ������Ҵ� id,name�� �����ϸ�
	 * type,brand,country,company�� �̿� ����
	 * */
	
	
	
	/*
	 * create �� modify��
	 * requestBody�� vo�� �ް� �Ǵµ� vo�ȿ� �ִ� name field �� �����
	 * */
	@Secured({"ROLE_ADMIN","ROLE_MANAGE"})
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ComponentVO vo) {
		log.info(vo.toString());
		return service.register(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Secured({"ROLE_ADMIN"})
	@PutMapping(value = "/{id}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ComponentVO vo,
			@PathVariable("id") Long id) {
		vo.setId(id);
		return service.modify(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * get ��  remove�� ��� url�� ���� type�� id �� �޾� ó����
	 * url�� type �� page�� ����
	 * */
	@GetMapping(value = "/{type}/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentVO> get(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return new ResponseEntity<>(service.get(vo), HttpStatus.OK);
	}
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping(value = "/{type}/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return service.remove(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
