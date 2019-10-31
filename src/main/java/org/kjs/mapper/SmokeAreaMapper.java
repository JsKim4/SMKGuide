package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.SmokeAreaVO;

public interface SmokeAreaMapper {
	public void insert(SmokeAreaVO vo);	// ������ ���
	
	public void delete(Long areaId);		// ������ ����
	
	public SmokeAreaVO get(Long areaId);	// ������ get
	
	public List<SmokeAreaVO> listSmokeArea();//������ list
}
