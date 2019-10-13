package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;

public interface TobaccoMapper {
	// Tobacco insert
	public int insert(TobaccoVO vo);

	// insert 후 Tobacco 번호 가져옴
	public void insertSelectKey(TobaccoVO vo);

	// 영구삭제
	public int delete(Long tobaccoId);

	// deleteFlag를 제외한 내용 업데이트
	public int update(TobaccoVO vo);

	// 1개 get
	public TobaccoVO get(Long tobaccoId);

	// 전체리스트
	public List<TobaccoVO> getList();

	// 검색용 + 페이지
	public List<TobaccoVO> getListWithPage(Criteria cri);

	// 검색용
	public int getTotalCount(Criteria cri);
}
