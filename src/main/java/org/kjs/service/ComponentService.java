package org.kjs.service;

import java.util.List;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;

public interface ComponentService {
	public void register(ComponentVO vo);

	public boolean modify(ComponentVO vo);

	public boolean remove(ComponentVO vo);
	
	public ComponentVO get(ComponentVO vo);
	
	public List<ComponentVO> getList(ComponentVO vo,Criteria cri);
	
	public int getTotalCount(ComponentVO vo);
	
}
