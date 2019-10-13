package org.kjs.mapper;

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
public class ComponentMapperTests {
	@Setter(onMethod_ = @Autowired)
	private ComponentMapper cmapper;
	
	@Test
	public void testGetTotalCount() {
		ComponentVO vo = new ComponentVO();
		vo.setType("country");
		log.info(cmapper.getTotalCount(vo));
		
	}
	
	@Test
	public void testGetListWithPage(){
		Criteria cri = new Criteria(1,10);
		ComponentVO vo = new ComponentVO();
		vo.setType("country");
		cmapper.getListWithPage(vo,cri).forEach(brand->log.info(brand));
	}
	
	
	@Test
	public void testGet() {
		ComponentVO vo = new ComponentVO();
		vo.setId(6L);
		vo.setType("brand");
		log.info(cmapper.get(vo));
	}
	
	
	@Test 
	public void testDelete() {
		ComponentVO vo = new ComponentVO();
		vo.setType("brand");
		vo.setId(5L);
		log.info("result : "+cmapper.delete(vo));
	}
	
	
	@Test
	public void testInsertSelectKey(){
		ComponentVO vo = new ComponentVO();
		vo.setName("county99");
		vo.setType("country");
		cmapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test 
	public void testInsert() {
		ComponentVO vo = new ComponentVO();
		vo.setName("type");
		vo.setType("type");
		cmapper.insert(vo);
		
	}
	@Test 
	public void testGetList() {
		ComponentVO vo = new ComponentVO();
		vo.setType("brand");
		cmapper.getList(vo).forEach(component->log.info("componentLog"+component));
	}
}
