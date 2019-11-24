package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.InfoVO;
import org.kjs.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class InfoServiceImpl implements InfoService {
	@Setter(onMethod_ = { @Autowired })
	InfoMapper mapper;

	@Override
	public void register(InfoVO vo) {
		// TODO Auto-generated method stub
		mapper.insert(vo);
	}

	@Override
	public boolean modify(InfoVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long infoId) {
		// TODO Auto-generated method stub
		return mapper.delete(infoId) == 1 ? true : false;
	}

	@Override
	public InfoVO get(Long infoId) {
		// TODO Auto-generated method stub
		return mapper.get(infoId);
	}

	@Override
	public List<InfoVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
