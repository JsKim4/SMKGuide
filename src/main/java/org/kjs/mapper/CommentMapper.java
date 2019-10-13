package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;

public interface CommentMapper {
	// smokelog insert
	public int insert(CommentVO vo);

	// insert 후 log 번호 가져옴
	public int insertSelectKey(CommentVO vo);

	// 삭제
	public int delete(Long commentId);

	// 업데이트
	public int update(CommentVO vo);

	// 1개 get
	public CommentVO get(Long commentId);

	// 전체리스트
	public List<CommentVO> getList();

	// 검색용 + 페이지
	public List<CommentVO> getListWithPage(Criteria cri);

	// 검색용
	public int getTotalCount(Criteria cri);
}
