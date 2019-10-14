package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.TobaccoVO;
import org.kjs.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentServiceTests {
	@Setter(onMethod_ = @Autowired)
	private CommentMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private CommentService service;
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("TM");
		cri.setTId(2L);
		cri.setMId(1L);
		log.info(service.getTotalCount(cri));
	}


	@Test
	public void testGetList() {
		Criteria cri = new Criteria(1,10);
		cri.setType("TM");
		cri.setTId(2L);
		cri.setMId(1L);
		service.getList(cri).forEach(vo -> log.info(vo));
	}

	@Test
	public void testRemove() {
		log.info(service.remove(69L));
	}

	@Test
	public void testModify() {
		CommentVO vo = service.get(70L);
		log.info(vo);
		vo.setContent("modifyTest");
		log.info("modify result : "+service.modify(vo));
		log.info(service.get(70L));
	}

	@Test
	public void testGet() {
		CommentVO vo = service.get(71L);
		log.info(vo);
	}


	@Test
	public void testRegister() {
		CommentVO vo = new CommentVO();
		MemberVO m = new MemberVO();
		TobaccoVO t = new TobaccoVO();
		t.setTobaccoId(2L);
		m.setMemberId(3L);
		vo.setContent("¿€º∫ register");
		vo.setMember(m);
		vo.setTobacco(t);
		service.register(vo);
		log.info(vo);
	}

}
