package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TobaccoServiceTests {
	@Setter(onMethod_= {@Autowired})
	private TobaccoService service;
	
	@Test
	public void getTotalCount() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("BT");
		cri.setNId(5L);
		cri.setMId(1L);
		cri.setTId(2L);
		log.info(service.getTotalCount(cri));
	}
	
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria(2, 10);
		cri.setType("BT");
		cri.setNId(5L);
		cri.setMId(1L);
		cri.setTId(2L);
		service.getList(cri).forEach(vo->log.info(vo));
	}

	@Test
	public void testModify() {
		TobaccoVO vo = service.get(12L);
		vo.setQuantity(15.0);
		vo.setBrand(new ComponentVO(8L, "brand", "brand"));
		vo.setTobaccoName("malrboro22");
		vo.setNicotine(2.0);
		vo.setTar(2.0);
		vo.setPrice(4500L);
		log.info(service.modify(vo));
	}

	@Test
	public void testRemove() {
		log.info(service.remove(10L));
	}

	@Test
	public void testRegister() {
		TobaccoVO vo = new TobaccoVO();
		vo.setQuantity(100.0);
		vo.setBrand(new ComponentVO(18L, "brand", "brand"));
		vo.setCountry(new ComponentVO(5L, "country", "country"));
		vo.setCompany(new ComponentVO(1L, "company", "company"));
		vo.setType(new ComponentVO(2L, "type", "type"));
		vo.setTobaccoName("tobacco14");
		vo.setNicotine(2.0);
		vo.setTar(2.0);
		vo.setPrice(4500L);
		service.register(vo);
		log.info(vo);

	}

	@Test
	public void testGet() {
		log.info(service.get(11L));
	}

}
