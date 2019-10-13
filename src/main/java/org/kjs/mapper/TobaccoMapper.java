package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.TobaccoVO;

public interface TobaccoMapper {
	// Tobacco insert
	public int insert(TobaccoVO vo);

	// insert �� Tobacco ��ȣ ������
	public void insertSelectKey(TobaccoVO vo);

	// ��������
	public int delete(Long tobaccoId);

	// deleteFlag�� ������ ���� ������Ʈ
	public int update(TobaccoVO vo);

	// 1�� get
	public TobaccoVO get(Long tobaccoId);

	// ��ü����Ʈ
	public List<TobaccoVO> getList();

	// �˻��� + ������
	public List<TobaccoVO> getListWithPage(Criteria cri);

	// �˻���
	public int getTotalCount(Criteria cri);
}
