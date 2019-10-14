package org.kjs.controller;

import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.domain.SmokelogPageDTO;
import org.kjs.domain.SmokelogVO;
import org.kjs.domain.TobaccoVO;
import org.kjs.service.SmokelogService;
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

@RequestMapping("/smokelog")
@RestController
@Slf4j
@AllArgsConstructor
public class SmokelogController {
	private SmokelogService service;
	/*
	 * 기본골자 url로 들어오는 type에 따라 table을 변경 하며 insert 실행 component로 묶인 table 의 구성요소는
	 * id,name만 존재하며 type,brand,country,company가 이에 속함
	 */

	/*
	 * create 와 modify는 requestBody로 vo를 받게 되는데 vo안에 있는 content field 만 사용함
	 */
	@PostMapping(value = "/{tobaccoId}/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@PathVariable("tobaccoId") Long tobaccoId) {
		SmokelogVO vo = new SmokelogVO();
		vo.setMemberId(1L);
		vo.setTobacco(new TobaccoVO(tobaccoId));
		return service.registe(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(value = "/{smokelogId}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody SmokelogVO vo, @PathVariable("smokelogId") Long smokelogId) {
		vo.setSmokelogId(smokelogId);
		return service.modify(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * url로 type 과 page, id 받음 type = member별 혹은 tobacco별인지 확인 type에따라 tid , mid 중
	 * 하나 setting
	 */
	@GetMapping(value = "pages/{type}/{id}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<SmokelogPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type,
			@PathVariable("id") Long id) {
		Criteria cri = new Criteria(page, 10);
		cri.setType(type);
		if (type.equals("M"))
			cri.setMId(id);
		if (type.equals("T"))
			cri.setTId(id);
		return new ResponseEntity<>(
				new SmokelogPageDTO(new PageDTO(cri, service.getTotalCount(cri)), service.getList(cri)), HttpStatus.OK);
	}

	/*
	 * get 과 remove의 경우 url을 통해 id 만 받아 처리함
	 */

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<SmokelogVO> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("id") Long id) {
		return service.remove(id) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
