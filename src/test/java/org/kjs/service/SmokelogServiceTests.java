package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.SearchDateBySmokelog;
import org.kjs.domain.SmokelogVO;
import org.kjs.domain.TobaccoVO;
import org.kjs.mapper.SmokelogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SmokelogServiceTests {
	@Setter(onMethod_ = @Autowired)
	private SmokelogMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private SmokelogService service;
	
	
	@Test
	public void testInsert() {
		SmokelogVO vo = new SmokelogVO();
		TobaccoVO tobacco = new TobaccoVO();
		tobacco.setTobaccoId(14L);
		vo.setTobacco(tobacco);
		log.info(service.registe(vo));
	}

	
	@Test
	public void testGet() {
		log.info(service.get(35L));
	}

	@Test
	public void testDelete() {
		service.remove(30L);
	}

	@Test
	public void testGetList() {
		Criteria cri = new Criteria(1,10);
		cri.setType("TM");
		cri.setMId(3L);
		service.getList(cri).forEach(vo->log.info(vo));
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1,10);
		cri.setType("T");
		cri.setTId(2L);
		cri.setMId(3L);
		log.info(service.getTotalCount(cri));
	}
	
	@Test
	public void testGetListByDate() {
		MemberVO member = new MemberVO();
		member.setMemberId(1L);
		SearchDateBySmokelog searchDate = new SearchDateBySmokelog("%Y-%m","2019-01-01","2019-12-01");
		log.info(service.getListByDate(searchDate, member));
	}
	
	
}
