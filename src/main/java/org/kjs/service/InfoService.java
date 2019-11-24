package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.InfoVO;

public interface InfoService {
	public void register(InfoVO vo);

	public boolean modify(InfoVO vo);

	public boolean remove(Long infoId);
	
	public InfoVO get(Long infoId);
	
	public List<InfoVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
