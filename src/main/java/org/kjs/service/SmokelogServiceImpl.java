package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.SmokelogVO;
import org.kjs.mapper.SmokelogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class SmokelogServiceImpl implements SmokelogService {

	@Setter(onMethod_ = { @Autowired })
	SmokelogMapper mapper;

	@Override
	public int registe(SmokelogVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}

	@Override
	public boolean remove(Long smokelogId) {
		// TODO Auto-generated method stub
		return mapper.delete(smokelogId) == 1 ? true : false;
	}

	@Override
	public boolean modify(SmokelogVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) == 1 ? true : false;
	}

	@Override
	public SmokelogVO get(Long smokelogId) {
		// TODO Auto-generated method stub
		return mapper.get(smokelogId);
	}

	@Override
	public List<SmokelogVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
