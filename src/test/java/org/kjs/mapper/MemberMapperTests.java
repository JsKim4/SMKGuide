package org.kjs.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;

	@Test
	public void testGetIdByEmail() {
		log.info(mapper.getIdByEmail("email"));
	}
	
	
	@Test
	public void testInsert() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("1234");
		vo.setMemberName("insertName");
		vo.setAddress("address");
		vo.setTelephone("010-000-0000");
		mapper.insert(vo);
	}

	@Test
	public void testGet() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("0000");
		vo = mapper.get(vo);
		log.info(vo);
	}

	@Test
	public void update() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("1234");
		vo = mapper.get(vo);
		vo.setConfirmPassword("0000");
		vo.setMemberName("updateTest");
		mapper.update(vo);
	}

	@Test
	public void testDelete() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("0000");
		vo = mapper.get(vo);
		mapper.delete(vo);
	}

	@Test
	public void testGetList() {
		mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(2,10);
		cri.setStartIndex();
		mapper.getListWithPage(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1,10);
		cri.setStartIndex();
		log.info(mapper.getTotalCount(cri));
	}
}
