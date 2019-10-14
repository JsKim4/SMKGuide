package org.kjs.service;

import java.util.List;

import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;

public interface CommentService {
	public int register(CommentVO vo);
	
	public boolean modify(CommentVO vo);
	
	public boolean remove(Long commentId);
	
	public CommentVO get(Long commentId);
	
	public List<CommentVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
