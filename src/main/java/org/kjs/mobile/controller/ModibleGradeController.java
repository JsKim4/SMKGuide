package org.kjs.mobile.controller;

import org.kjs.controller.HomeController;
import org.kjs.domain.Criteria;
import org.kjs.domain.GradePageDTO;
import org.kjs.domain.GradeVO;
import org.kjs.domain.MemberVO;
import org.kjs.domain.PageDTO;
import org.kjs.service.GradeService;
import org.kjs.service.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mobile/grade")
@RestController
@Slf4j
@AllArgsConstructor
public class ModibleGradeController {

	private GradeService service;
	private MobileService mService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody GradeVO vo) {
		vo.setMember(mService.getMemberByToken(vo.getMember().getToken()));
		return service.register(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping(value = "pages/{page}", consumes = "application/json" , produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<GradePageDTO> getList(@PathVariable("page") int page,@RequestBody MemberVO vo) {
		Criteria cri = new Criteria(page, 10);
		cri.setType("M");
		cri.setMId(mService.getMemberByToken(vo.getToken()).getMemberId());
		logger.info("\n"+cri);
		logger.info(service.getListWithPage(cri).toString());
		return new ResponseEntity<>(
				new GradePageDTO(new PageDTO(cri, service.getTotalCount(cri)), service.getListWithPage(cri)), HttpStatus.OK);
	}
}
