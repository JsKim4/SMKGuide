package org.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kjs.domain.Criteria;
import org.kjs.domain.InfoVO;

public interface InfoMapper {
	public void insert(@Param("vo") InfoVO vo);

	public int update(@Param("vo") InfoVO vo);

	public InfoVO get(Long infoId);

	public int delete(Long infoId);

	public List<InfoVO> getList(@Param("cri") Criteria cri);

	public List<InfoVO> getListWithPage(@Param("cri") Criteria cri);

	public int getTotalCount(@Param("cri") Criteria cri);
}
