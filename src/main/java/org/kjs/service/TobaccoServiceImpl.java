package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;
import org.kjs.mapper.TobaccoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TobaccoServiceImpl implements TobaccoService {

	@Setter(onMethod_ = @Autowired)
	TobaccoMapper mapper;

	@Override
	public int register(TobaccoVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertSelectKey(vo);

	}

	@Override
	public boolean modify(TobaccoVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long tobaccoId) {
		// TODO Auto-generated method stub
		return mapper.delete(tobaccoId) == 1 ? true : false;
	}

	@Override
	public TobaccoVO get(Long tobaccoId) {
		// TODO Auto-generated method stub
		return mapper.get(tobaccoId);
	}

	@Override
	public List<TobaccoVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
