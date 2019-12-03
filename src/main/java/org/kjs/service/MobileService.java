package org.kjs.service;

import java.util.List;

import org.kjs.domain.CommentVO;
import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.SmokeAreaVO;
import org.kjs.domain.TobaccoVO;

public interface MobileService {
	public List<TobaccoVO> getListTobacco();
	public List<ComponentVO> getListComponent(ComponentVO vo);
	public List<SmokeAreaVO> getListSmokeArea();
	public List<CommentVO> getListCommentByTobaccoWithPage(Criteria cri);
	public int getCommentTotalCount(Criteria cri);
	public MemberVO getMemberByToken(String token);
	public String getToken(MemberVO vo);
}
