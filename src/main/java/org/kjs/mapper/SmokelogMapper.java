package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.SmokelogVO;

public interface SmokelogMapper {
		// smokelog insert
		public int insert(SmokelogVO vo);

		// insert �� log ��ȣ ������
		public void insertSelectKey(SmokelogVO vo);

		// ����
		public int delete(Long smokelogId);

		// ������Ʈ
		public int update(SmokelogVO vo);

		// 1�� get
		public SmokelogVO get(Long smokelogId);

		// ��ü����Ʈ
		public List<SmokelogVO> getList();

		// �˻��� + ������
		public List<SmokelogVO> getListWithPage(Criteria cri);

		// �˻���
		public int getTotalCount(Criteria cri);
}
