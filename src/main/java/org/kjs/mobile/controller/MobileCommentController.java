package org.kjs.mobile.controller;

import org.kjs.controller.HomeController;
import org.kjs.domain.CommentPageDTO;
import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.PageDTO;
import org.kjs.service.CommentService;
import org.kjs.service.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RequestMapping("/mobile/comment")
@RestController
@Slf4j
@AllArgsConstructor
public class MobileCommentController {
	private MobileService service;
	private CommentService cservice;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value = "pages/{type}/{id}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type,
			@PathVariable("id") Long id) {
		Criteria cri = new Criteria(page, 10);
		cri.setType(type);
		if (type.equals("M")){
			cri.setMId(id);
		}
		if (type.equals("T"))
			cri.setTId(id);
		return new ResponseEntity<>(
				new CommentPageDTO(new PageDTO(cri, service.getCommentTotalCount(cri)), 
						service.getListCommentByTobaccoWithPage(cri)), HttpStatus.OK);
	}
	
	@PostMapping(value = "pages/{page}", consumes = "application/json", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentPageDTO> getListMemberComment(@PathVariable("page") int page, @RequestBody MemberVO vo) {
		Criteria cri = new Criteria(page, 10);
		cri.setType("M");
		cri.setMId(service.getMemberByToken(vo.getToken()).getMemberId());
		return new ResponseEntity<>(
				new CommentPageDTO(new PageDTO(cri, service.getCommentTotalCount(cri)), 
						service.getListCommentByTobaccoWithPage(cri)), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody CommentVO vo) {
		vo.setMember(service.getMemberByToken(vo.getMember().getToken()));
		return cservice.register(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
