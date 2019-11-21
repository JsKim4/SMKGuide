package org.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;

public interface MobileMapper {
	// �˻��� + ������
		public List<TobaccoVO> getListTobacco(Criteria cri);
		public List<ComponentVO> getListComponent(@Param("vo") ComponentVO vo);
}
