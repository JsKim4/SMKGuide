package org.kjs.service;

import java.util.List;

import org.kjs.domain.SmokeAreaVO;
import org.kjs.mapper.SmokeAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;


@Service
public class SmokeAreaServiceImpl implements SmokeAreaService {

	@Setter(onMethod_= {@Autowired})
	SmokeAreaMapper mapper;
	
	@Override
	public void register(SmokeAreaVO vo) {
		mapper.insert(vo);

	}

	@Override
	public void remove(Long areaId) {
		mapper.delete(areaId);

	}

	@Override
	public SmokeAreaVO get(Long areaId) {
		// TODO Auto-generated method stub
		return mapper.get(areaId);
	}

	@Override
	public List<SmokeAreaVO> listSmokeArea() {
		// TODO Auto-generated method stub
		return mapper.listSmokeArea();
	}

}
