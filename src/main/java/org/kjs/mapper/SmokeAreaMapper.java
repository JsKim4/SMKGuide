package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.SmokeAreaVO;

public interface SmokeAreaMapper {
	public void insert(SmokeAreaVO vo);	// 软楷备开 殿废
	
	public void delete(Long areaId);		// 软楷备开 昏力
	
	public SmokeAreaVO get(Long areaId);	// 软楷备开 get
	
	public List<SmokeAreaVO> listSmokeArea();//软楷备开 list
}
