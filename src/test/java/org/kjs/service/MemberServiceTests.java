package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTests {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private MemberService service;

	@Test
	public void testGetIdByEmail() {
		log.info(mapper.getIdByEmail("email"));
	}
	
	
	@Test
	public void testJoin() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest1@test");
		vo.setPassword("1234");
		vo.setMemberName("insertName");
		vo.setAddress("address");
		vo.setTelephone("010-000-0000");
		service.join(vo);
	}

	@Test
	public void testLogin() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest1@test");
		vo.setPassword("0000");
		vo = service.login(vo);
		log.info(vo);
	}

	@Test
	public void testModify() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest1@test");
		vo.setPassword("0000");
		vo = service.login(vo);
		vo.setConfirmPassword("1234");
		vo.setMemberName("updateTest");
		service.modify(vo);
	}

	@Test
	public void testLeave() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest1@test");
		vo.setPassword("0000");
		vo = service.login(vo);
		service.leave(vo);
	}

	@Test
	public void testGetList() {
		service.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(1,10);
		cri.setStartIndex();
		service.getListWithPage(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1,10);
		cri.setStartIndex();
		log.info(mapper.getTotalCount(cri));
	}
}
