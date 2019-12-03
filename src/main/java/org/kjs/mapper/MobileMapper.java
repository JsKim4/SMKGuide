package org.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kjs.domain.CommentVO;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.SmokeAreaVO;
import org.kjs.domain.TobaccoVO;

public interface MobileMapper {
	// �˻��� + ������
	public MemberVO getMemberByToken(String token);
	public String getToken(MemberVO vo);
	public List<TobaccoVO> getListTobacco();
	public List<ComponentVO> getListComponent(@Param("vo") ComponentVO vo);
	public List<SmokeAreaVO> getListSmokeArea();
	public List<CommentVO> getListCommnetByTobaccoIdWithPage(Criteria cri);
	public int getCommentTotalCount(Criteria cri);
}
