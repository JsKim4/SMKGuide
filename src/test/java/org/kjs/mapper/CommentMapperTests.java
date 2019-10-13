package org.kjs.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;
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
public class CommentMapperTests {
	@Setter(onMethod_ = @Autowired)
	private CommentMapper mapper;
	
	
	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(1,10);
		cri.setType("TM");
		cri.setTId(2L);
		cri.setMId(3L);
		log.info(cri.getTypeArr()[0]+"  "+cri.getTypeArr()[1]);
		mapper.getListWithPage(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(54L)>0?"success":"fail");
	}
	
	@Test
	public void testUpdate() {
		CommentVO vo = mapper.get(55L);
		log.info(vo);
		vo.setContent("updateContent");
		mapper.update(vo);
	}

	@Test
	public void testGet() {
		CommentVO vo = mapper.get(55L);
		log.info(vo);
	}

	@Test
	public void testInsertSelectKey() {
		CommentVO vo = new CommentVO();
		MemberVO m = new MemberVO();
		TobaccoVO t = new TobaccoVO();
		t.setTobaccoId(2L);
		m.setMemberId(1L);
		vo.setContent("작성 content");
		vo.setMember(m);
		vo.setTobacco(t);
		mapper.insertSelectKey(vo);
		log.info(vo);
	}

	@Test
	public void testInsert() {
		CommentVO vo = new CommentVO();
		MemberVO m = new MemberVO();
		TobaccoVO t = new TobaccoVO();
		t.setTobaccoId(2L);
		m.setMemberId(3L);
		vo.setContent("작성 content");
		vo.setMember(m);
		vo.setTobacco(t);
		mapper.insert(vo);
	}

}
