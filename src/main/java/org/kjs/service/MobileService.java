package org.kjs.service;

import java.util.List;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.SmokeAreaVO;
import org.kjs.domain.TobaccoVO;

public interface MobileService {
	public List<TobaccoVO> getListTobacco(Criteria cri);
	public List<ComponentVO> getListComponent(ComponentVO vo);
	public List<SmokeAreaVO> getListSmokeArea();
}
