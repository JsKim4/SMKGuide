package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.SmokelogVO;

public interface SmokelogService {
	public int registe(SmokelogVO vo);

	public boolean remove(Long smokelogId);

	public boolean modify(SmokelogVO vo);

	public SmokelogVO get(Long smokelogId);

	public List<SmokelogVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	


}
