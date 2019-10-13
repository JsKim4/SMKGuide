package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;

public interface CommentMapper {
	// smokelog insert
	public int insert(CommentVO vo);

	// insert �� log ��ȣ ������
	public int insertSelectKey(CommentVO vo);

	// ����
	public int delete(Long commentId);

	// ������Ʈ
	public int update(CommentVO vo);

	// 1�� get
	public CommentVO get(Long commentId);

	// ��ü����Ʈ
	public List<CommentVO> getList();

	// �˻��� + ������
	public List<CommentVO> getListWithPage(Criteria cri);

	// �˻���
	public int getTotalCount(Criteria cri);
}
