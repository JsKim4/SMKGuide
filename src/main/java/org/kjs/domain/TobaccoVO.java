package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TobaccoVO {		//���
	private Long tobaccoId;				//��������ȣ
	private String tobaccoName;			//����̸�
	private Boolean deleteFlag;			//��������
	private ComponentVO country;		//����
	private ComponentVO company;		//ȸ��
	private ComponentVO type;			//Ÿ��
	private ComponentVO brand;			//�귣��
	private Double tar;					//Ÿ�� ������
	private Double nicotine;			//����ƾ ������
	private Double quantity;			//����
	private Long price;					//����
	private int commentCnt;				//comment ����
	private AttachVO attach;
	
	public TobaccoVO() {
		this(-1L);
	}
	public TobaccoVO(Long tobaccoId) {
		this.setQuantity(20D);
		this.setPrice(4500L);
		this.setTobaccoId(tobaccoId);
	}
}
