package org.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kjs.domain.Criteria;
import org.kjs.domain.DateBySmokelog;
import org.kjs.domain.MemberVO;
import org.kjs.domain.SearchDateBySmokelog;
import org.kjs.domain.SmokelogVO;

public interface SmokelogMapper {
		public int insert(SmokelogVO vo);

		public int insertSelectKey(SmokelogVO vo);

		public int delete(Long smokelogId);

		public int update(SmokelogVO vo);

		public SmokelogVO get(Long smokelogId);

		public List<SmokelogVO> getList();

		public List<SmokelogVO> getListWithPage(Criteria cri);

		public int getTotalCount(Criteria cri);
		
		public List<DateBySmokelog> getCountSmokelogByDate(@Param("searchDate")SearchDateBySmokelog searchDate,@Param("member")MemberVO member);
}
