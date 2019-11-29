package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.AuthVO;

public interface AuthMapper {
	public void insert(AuthVO vo);
	public List<AuthVO> getList(String memberId);
	public void delete(String memberId);
	
}
