package org.kjs.mobile.controller;

import org.kjs.controller.HomeController;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.PageDTO;
import org.kjs.domain.SmokelogPageDTO;
import org.kjs.domain.SmokelogVO;
import org.kjs.service.MobileService;
import org.kjs.service.SmokelogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RequestMapping("/mobile/smokelog")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileSmokelogController {
	private SmokelogService service;
	private MobileService mService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PutMapping(value = "/{smokelogId}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody SmokelogVO vo, @PathVariable("smokelogId") Long smokelogId) {
		vo.setMember(mService.getMemberByToken(vo.getMember().getToken()));
		return service.modify(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping(value = "pages/{page}", consumes = "application/json", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<SmokelogPageDTO> getList(@PathVariable("page") int page, @RequestBody MemberVO vo) {
		Criteria cri = new Criteria(page, 10);
		cri.setType("M");
		cri.setMId(mService.getMemberByToken(vo.getToken()).getMemberId());
		logger.info(service.getList(cri).toString());
		logger.info("\n"+cri);
		return new ResponseEntity<>(
				new SmokelogPageDTO(new PageDTO(cri, service.getTotalCount(cri)), service.getList(cri)), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody SmokelogVO vo) {
		vo.setMember(mService.getMemberByToken(vo.getMember().getToken()));
		return service.registe(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

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
