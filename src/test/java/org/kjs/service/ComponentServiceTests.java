package org.kjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ComponentServiceTests {
	@Setter(onMethod_= {@Autowired})
	private ComponentService service;
	
	@Test
	public void getTotalCount() {
		ComponentVO vo = new ComponentVO();
		vo.setType("brand");
		log.info(service.getTotalCount(vo));
	}
	
	@Test
	public void testGetList(){
		ComponentVO vo = new ComponentVO();
		vo.setType("brand");
		Criteria cri = new Criteria(1,10);
		service.getList(vo, cri).forEach(v -> log.info(v));
	}
	
	@Test
	public void testUpdate() {
		ComponentVO vo = new ComponentVO();
		vo.setId(100L);
		vo.setType("country");
		vo.setName("영국");
		log.info(service.modify(vo));
	}
	
	@Test
	public void testGet() {
		ComponentVO vo = new ComponentVO();
		vo.setId(6L);
		vo.setType("country");
		log.info(service.get(vo));
	}
	
	@Test
	public void testRegister() {
		ComponentVO vo = new ComponentVO();
		vo.setType("country");
		vo.setName("한국");
		service.register(vo);
	}
}
