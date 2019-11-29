package org.kjs.controller;

import org.kjs.domain.CommentPageDTO;
import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.service.CommentService;
import org.kjs.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RequestMapping("/comment")
@RestController
@Slf4j
@AllArgsConstructor
public class CommentController {
	// Comment Service�� ó��
	private CommentService service;
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@PreAuthorize("principal.username == #vo.member.email")
	@Secured({"ROLE_USER"})
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody CommentVO vo) {
		vo.getMember().setMemberId((long)memberService.getIdByEmail(vo.getMember().getEmail()));
		return service.register(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PreAuthorize("principal.username == #vo.member.email")
	@Secured({"ROLE_USER"})
	@PutMapping(value = "/{id}", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody CommentVO vo, @PathVariable("id") Long id) {
		vo.setCommentId(id);
		return service.modify(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

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
		return new ResponseEntity<>(
				new CommentPageDTO(new PageDTO(cri, service.getTotalCount(cri)), service.getList(cri)), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentVO> get(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
	@PreAuthorize("principal.username == #vo.member.email")
	@Secured({"ROLE_USER"})
	@DeleteMapping(value = "/{id}",consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@RequestBody CommentVO vo,@PathVariable("id") Long id) {
		return service.remove(id) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
