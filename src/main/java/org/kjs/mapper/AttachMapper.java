package org.kjs.mapper;

import org.kjs.domain.AttachVO;

public interface AttachMapper {
	public void insert(AttachVO vo);
	
	public void delete(String uuid);
	
	public AttachVO get(String uuid);
}
