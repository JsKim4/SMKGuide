package org.kjs.service;

import java.util.List;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.SmokeAreaVO;
import org.kjs.domain.TobaccoVO;
import org.kjs.mapper.MobileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class MobileServiceImpl implements MobileService {
	@Setter(onMethod_= {@Autowired})
	MobileMapper mapper;
	
	@Override
	public List<TobaccoVO> getListTobacco(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListTobacco(cri);
	}

	@Override
	public List<ComponentVO> getListComponent(ComponentVO vo) {
		// TODO Auto-generated method stub
		return mapper.getListComponent(vo);
	}

	@Override
	public List<SmokeAreaVO> getListSmokeArea() {
		// TODO Auto-generated method stub
		return mapper.getListSmokeArea();
	}
	
}
