package org.kjs.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {				//������ ó���� ���� DTO
	private int startPage;			//���� ������
	private int endPage;			//��������

	private boolean prev, next;		//��������(startPage-1) ��������(endPage+1) ��� ����

	private int total;				//��ü �Խñ� ��
	private Criteria cri;			//�������� ����, ���޹��� ������ ��ȣ ���

	public PageDTO(Criteria cri, int total) {		//�ʱ�ȭ
		this.cri = cri;	
		this.total = total;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;		//���� ������ 1���ڸ��� �ø�
		this.startPage = this.endPage - 9;									//������ ������ -9
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));		//���� ������ ������ ��ȣ
		
		if(realEnd<this.endPage)				//���������������� ���� �������� Ŭ ���
			this.endPage = realEnd;
		
		this.prev = this.startPage > 1;			//������������ ù° ���������� Ŭ��� prev���
		
		this.next = this.endPage < realEnd;		//���� ������ ����������  ���� ������ �������� Ŭ ��� next ���
	}
}
