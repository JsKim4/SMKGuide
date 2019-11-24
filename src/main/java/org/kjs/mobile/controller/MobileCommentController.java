package org.kjs.mobile.controller;

import org.kjs.controller.HomeController;
import org.kjs.domain.CommentPageDTO;
import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.service.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping(value = "pages/{type}/{id}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type,
			@PathVariable("id") Long id) {
		Criteria cri = new Criteria(page, 10);
		cri.setType(type);
		if (type.equals("M"))
			cri.setMId(id);
		if (type.equals("T"))
			cri.setTId(id);
		logger.info(service.getListCommentByTobaccoWithPage(cri).toString());
		return new ResponseEntity<>(
				new CommentPageDTO(new PageDTO(cri, service.getCommentTotalCount(cri)), 
						service.getListCommentByTobaccoWithPage(cri)), HttpStatus.OK);
	}
}
