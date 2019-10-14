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
	 * url�� type �� page�� ����
	 * */
	@GetMapping(value = "pages/{type}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type) {
		ComponentVO vo = new ComponentVO(type);
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<>(service.getList(vo, cri), HttpStatus.OK);
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

	@DeleteMapping(value = "/{type}/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return service.remove(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
