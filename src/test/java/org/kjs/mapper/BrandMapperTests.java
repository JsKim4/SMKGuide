package org.kjs.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.BrandVO;
import org.kjs.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BrandMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BrandMapper mapper;
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(2,10);
		log.info(mapper.getTotalCount(cri));
		
	}
	
	@Test
	public void testGetListWithPage(){
		Criteria cri = new Criteria(2,10);
		mapper.getListWithPage(cri).forEach(brand->log.info(brand));
	}
	
	
	@Test
	public void testGet() {
		log.info(mapper.get(18L));
	}
	
	
	@Test 
	public void testDelete() {
		log.info("result : "+mapper.delete(15L));
	}
	
	
	@Test
	public void testInsertSelectKey(){
		BrandVO vo = new BrandVO();
		vo.setBrandName("test Name");
		mapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test 
	public void testInsert() {
		BrandVO vo = new BrandVO();
		vo.setBrandName("test Name");
		mapper.insert(vo);
		
	}
	@Test 
	public void testGetList() {
		mapper.getList().forEach(brand->log.info("brandLog"+brand));
	}
}
