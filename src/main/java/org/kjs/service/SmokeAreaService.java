package org.kjs.service;

import java.util.List;

import org.kjs.domain.SmokeAreaVO;

public interface SmokeAreaService {
	public void register(SmokeAreaVO vo);
	
	public void remove(Long areaId);
	
	public SmokeAreaVO get(Long areaId);
	
	public List<SmokeAreaVO> listSmokeArea();
}
