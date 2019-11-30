package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.GradeVO;

public interface GradeService {
	public GradeVO get(GradeVO vo);
	public int register(GradeVO vo);
	public List<GradeVO> getListWithPage(Criteria cri);
	public int getTotalCount(Criteria cri);
}
