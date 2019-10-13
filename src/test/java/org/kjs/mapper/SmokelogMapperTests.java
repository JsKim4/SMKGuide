package org.kjs.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.SmokelogVO;
import org.kjs.domain.TobaccoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SmokelogMapperTests {
	@Setter(onMethod_ = @Autowired)
	private SmokelogMapper mapper;

	@Test
	public void testInsert() {
		SmokelogVO vo = new SmokelogVO();
		vo.setMemberId(1L);
		TobaccoVO tobacco = new TobaccoVO();
		tobacco.setTobaccoId(2L);
		vo.setTobacco(tobacco);
		log.info(mapper.insert(vo));
	}

	@Test
	public void testGet() {
		log.info(mapper.get(1L));
	}

	@Test
	public void testInsertSelectKey() {
		SmokelogVO vo = new SmokelogVO();
		vo.setMemberId(1L);
		TobaccoVO tobacco = new TobaccoVO();
		tobacco.setTobaccoId(3L);
		vo.setTobacco(tobacco);
		mapper.insertSelectKey(vo);
		log.info(vo);
	}

	@Test
	public void testDelete() {
		mapper.delete(2L);
	}

	@Test
	public void testGetList() {
		mapper.getList().forEach(vo->log.info(vo));
	}
	
	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(1,20);
		cri.setStartIndex();
		cri.setType("T");
		cri.setMId(1L);
		cri.setTId(2L);
		mapper.getListWithPage(cri).forEach(vo->log.info(vo));
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1,10);
		cri.setStartIndex();
		cri.setType("T");
		cri.setMId(1L);
		cri.setTId(3L);
		log.info(mapper.getTotalCount(cri));
	}
}
