package org.kjs.mapper;

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
public class TobaccoMapperTests {
	@Setter(onMethod_ = @Autowired)
	private TobaccoMapper tmapper;

	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(2, 10);
		cri.setStartIndex();
		tmapper.getListWithPage(cri).forEach(vo -> log.info(vo));
	}

	@Test
	public void testGetList() {
		tmapper.getList().forEach(vo -> log.info(vo));
	}

	@Test
	public void testUpdate() {
		TobaccoVO t = new TobaccoVO();
		t.setTobaccoId(2L);
		t.setAmount(100.0);
		t.setBrand(new ComponentVO(17L, "brand", "brand"));
		t.setCountry(new ComponentVO(5L, "country", "country"));
		t.setCompany(new ComponentVO(1L, "company", "company"));
		t.setType(new ComponentVO(2L, "type", "type"));
		t.setTobaccoName("malrboro");
		t.setNicotine(2.0);
		t.setTar(2.0);
		t.setPrice(4500L);
		log.info(tmapper.update(t));
	}

	@Test
	public void testDelete() {
		log.info("result : " + (tmapper.delete(1L) == 1 ? "true" : "false"));
	}

	@Test
	public void testInsertSelectKey() {
		TobaccoVO t = new TobaccoVO();
		t.setAmount(100.0);
		t.setBrand(new ComponentVO(17L, "brand", "brand"));
		t.setCountry(new ComponentVO(5L, "country", "country"));
		t.setCompany(new ComponentVO(1L, "company", "company"));
		t.setType(new ComponentVO(2L, "type", "type"));
		t.setTobaccoName("tobacco");
		t.setNicotine(2.0);
		t.setTar(2.0);
		t.setPrice(4500L);
		tmapper.insertSelectKey(t);
		log.info(t);
	}

	@Test
	public void testInsert() {
		TobaccoVO t = new TobaccoVO();
		t.setAmount(100.0);
		t.setBrand(new ComponentVO(17L, "brand", "brand"));
		t.setCountry(new ComponentVO(5L, "country", "country"));
		t.setCompany(new ComponentVO(1L, "company", "company"));
		t.setType(new ComponentVO(2L, "type", "type"));
		t.setTobaccoName("tobacco");
		t.setNicotine(2.0);
		t.setTar(2.0);
		t.setPrice(4500L);
		tmapper.insert(t);

	}

	@Test
	public void testGet() {
		log.info(tmapper.get(2L));
	}

}
