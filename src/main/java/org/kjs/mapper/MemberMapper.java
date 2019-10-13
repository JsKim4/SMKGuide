package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;

public interface MemberMapper {
	// 회원가입
	public int insert(MemberVO vo);

	// 회원 정보 수정
	public int update(MemberVO vo);
	
	// 로그인 --> *이메일 + 비밀번호*
	public MemberVO get(MemberVO vo);
	
	// 회원 탈퇴 *이메일 + 비밀번호*
	public int delete(MemberVO vo);


	/*
	 * 
	 * 관리자 페이지 용
	 * 
	 **/

	// 전체리스트
	public List<MemberVO> getList();

	// 검색용 + 페이지
	public List<MemberVO> getListWithPage(Criteria cri);

	// 검색용
	public int getTotalCount(Criteria cri);
}
