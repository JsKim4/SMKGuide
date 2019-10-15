package org.kjs.service;

import java.util.List;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.mapper.ComponentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ComponentServiceImpl implements ComponentService {

	@Setter(onMethod_ = @Autowired)
	ComponentMapper mapper;

	@Override
	public int register(ComponentVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertSelectKey(vo);

	}

	@Override
	public boolean modify(ComponentVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) == 1 ? true : false;
	}

	@Override
	public boolean remove(ComponentVO vo) {
		// TODO Auto-generated method stub
		return mapper.delete(vo) == 1 ? true : false;
	}

	@Override
	public ComponentVO get(ComponentVO vo) {
		// TODO Auto-generated method stub
		String type = vo.getType();
		vo = mapper.get(vo);
		vo.setType(type);
		return vo;
	}

	@Override
	public List<ComponentVO> getList(ComponentVO vo, Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(vo, cri);
	}

	@Override
	public int getTotalCount(ComponentVO vo,Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(vo,cri);
	}

	@Override
	public List<ComponentVO> getRegistList(ComponentVO vo) {
		// TODO Auto-generated method stub
		return mapper.getList(vo);
	}

}
