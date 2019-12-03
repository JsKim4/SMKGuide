package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.GradeVO;
import org.kjs.domain.MemberVO;
import org.kjs.domain.TobaccoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GradeServiceTests {
	@Setter(onMethod_=@Autowired)
	private GradeService service;
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("T");
		cri.setTId(2L);
		log.info(service.getTotalCount(cri));
	}


	@Test
	public void testGetList() {
		Criteria cri = new Criteria(1,10);
		cri.setType("M");
		cri.setMId(74L);
		log.info(service.getListWithPage(cri).toString());
	}

	@Test
	public void testRemove() {
	}


	@Test
	public void testGet() {
		
	}


	@Test
	public void testRegister() {
		GradeVO vo = new GradeVO();
		MemberVO member = new MemberVO();
		TobaccoVO tobacco = new TobaccoVO();
		tobacco.setTobaccoId(84L);
		member.setMemberId(74L);
		vo.setTobacco(tobacco);
		vo.setMember(member);
		vo.setScore(5L);
		service.register(vo);
	}

}
