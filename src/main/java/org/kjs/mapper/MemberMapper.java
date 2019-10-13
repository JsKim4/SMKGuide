package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.domain.TobaccoVO;

public interface MemberMapper {
	// ȸ������
	public int insert(MemberVO vo);

	// ȸ�� ���� ����
	public int update(MemberVO vo);

	// ȸ�� Ż�� *�̸��� + ��й�ȣ*
	public int delete(MemberVO vo);

	// �α��� --> *�̸��� + ��й�ȣ*
	public int get(MemberVO vo);

	/*
	 * 
	 * ������ ������ ��
	 * 
	 */

	// ��ü����Ʈ
	public List<TobaccoVO> getList();

	// �˻��� + ������
	public List<TobaccoVO> getListWithPage(Criteria cri);

	// �˻���
	public int getTotalCount(Criteria cri);
}
