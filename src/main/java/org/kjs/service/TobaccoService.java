package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;

public interface TobaccoService {
	public int register(TobaccoVO vo);

	public boolean modify(TobaccoVO vo);

	public boolean remove(Long tobaccoId);
	
	public TobaccoVO get(Long tobaccoId);
	
	public List<TobaccoVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
}
