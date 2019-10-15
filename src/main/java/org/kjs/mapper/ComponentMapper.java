package org.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;

public interface ComponentMapper {
	public int insert(@Param("vo") ComponentVO vo);

	public int insertSelectKey(@Param("vo") ComponentVO vo);

	public int delete(@Param("vo") ComponentVO vo);

	public int update(@Param("vo") ComponentVO vo);

	public ComponentVO get(@Param("vo") ComponentVO vo);

	public List<ComponentVO> getList(@Param("vo") ComponentVO vo);

	public List<ComponentVO> getListWithPage(@Param("vo") ComponentVO vo,@Param("cri") Criteria cri);

	public int getTotalCount(@Param("vo") ComponentVO vo,@Param("cri") Criteria cri);
}
