package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;

public interface MemberService {
	public int join(MemberVO vo);

	public int modify(MemberVO vo);

	public MemberVO login(String email);

	public Integer getIdByEmail(String email);

	public int leave(MemberVO vo);

	public List<MemberVO> getList(Criteria cri);

	public int getTotalCount(Criteria cri);
	
}
