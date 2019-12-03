package org.kjs.mapper;

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
public class GradeMapperTests {
	@Setter(onMethod_ = @Autowired)
	private GradeMapper mapper;

	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("M");
		cri.setTId(74L);
		log.info(mapper.getListWithPage(cri));
	}

	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("M");
		cri.setTId(74L);
		mapper.getTotalCount(cri);
	}

	@Test
	public void testGetList() {
	}

	@Test
	public void testInsert() {
		GradeVO vo = new GradeVO();
		MemberVO member = new MemberVO();
		member.setMemberId(65L);
		TobaccoVO tobacco = new TobaccoVO();
		tobacco.setTobaccoId(84L);
		member.setMemberId(65L);
		vo.setMember(member);
		vo.setTobacco(tobacco);
		vo.setScore(1L);
		GradeVO before = mapper.get(vo);
		log.info("first Vo"+before);
		if(before==null){
			mapper.insert(vo);
			mapper.updateGradeTobacco(vo, 1);
		}
		else {
			log.info("after : "+vo.getScore());
			mapper.update(vo);
			vo.setScore(vo.getScore()-before.getScore());
			log.info("before : "+before.getScore());
			log.info("after : "+vo.getScore());
			mapper.updateGradeTobacco(vo, 0);
		}
	}

}
