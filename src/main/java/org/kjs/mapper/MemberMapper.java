package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;

public interface MemberMapper {
	// ȸ������
	public int insert(MemberVO vo);

	// ȸ�� ���� ����
	public int update(MemberVO vo);
	
	// �α��� --> *�̸��� + ��й�ȣ*
	public MemberVO get(MemberVO vo);
	
	// ȸ�� Ż�� *�̸��� + ��й�ȣ*
	public int delete(MemberVO vo);


	/*
	 * 
	 * ������ ������ ��
	 * 
	 **/

	// ��ü����Ʈ
	public List<MemberVO> getList();

	// �˻��� + ������
	public List<MemberVO> getListWithPage(Criteria cri);

	// �˻���
	public int getTotalCount(Criteria cri);
}
