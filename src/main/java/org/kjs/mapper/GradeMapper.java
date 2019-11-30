package org.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kjs.domain.Criteria;
import org.kjs.domain.GradeVO;

public interface GradeMapper {
	public GradeVO get(GradeVO vo);
	public int update(GradeVO vo);
	public int insert(GradeVO vo);
	public List<GradeVO> getListWithPage(Criteria cri);
	public int getTotalCount(Criteria cri);
	public int updateGradeTobacco(@Param("vo") GradeVO vo,@Param("insert") int num);
}
