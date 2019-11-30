package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.GradeVO;
import org.kjs.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
public class GradeServiceImpl implements GradeService{
	@Setter(onMethod_= {@Autowired})
	GradeMapper mapper;
	
	@Override
	public GradeVO get(GradeVO vo) {
		return mapper.get(vo);
	}
	@Transactional
	@Override
	public int register(GradeVO vo) {
		// TODO Auto-generated method stub
		GradeVO before = mapper.get(vo);
		if(before==null){
			mapper.insert(vo);
			mapper.updateGradeTobacco(vo, 1);
			return 1;
		}
		else {
			mapper.update(vo);
			vo.setScore(vo.getScore()-before.getScore());
			mapper.updateGradeTobacco(vo, 0);
		}
		return 1;
	}

	@Override
	public List<GradeVO> getListWithPage(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}
	
}
