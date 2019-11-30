package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.GradeVO;
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
		cri.setType("TM");
		cri.setTId(2L);
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
		vo.setMemberId(74L);
		vo.setTobaccoId(84L);
		vo.setScore(2L);
		service.register(vo);
	}

}
