package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.SmokelogVO;

public interface SmokelogMapper {
		// smokelog insert
		public int insert(SmokelogVO vo);

		// insert 후 log 번호 가져옴
		public void insertSelectKey(SmokelogVO vo);

		// 삭제
		public int delete(Long smokelogId);

		// 업데이트
		public int update(SmokelogVO vo);

		// 1개 get
		public SmokelogVO get(Long smokelogId);

		// 전체리스트
		public List<SmokelogVO> getList();

		// 검색용 + 페이지
		public List<SmokelogVO> getListWithPage(Criteria cri);

		// 검색용
		public int getTotalCount(Criteria cri);
}
