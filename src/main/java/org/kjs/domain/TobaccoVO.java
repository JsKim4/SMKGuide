package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TobaccoVO {		//���
	Long tobaccoId;				//��������ȣ
	String tobaccoName;			//����̸�
	Boolean deleteFlag;			//��������
	ComponentVO country;		//����
	ComponentVO company;		//ȸ��
	ComponentVO type;			//Ÿ��
	ComponentVO brand;			//�귣��
	Double tar;					//Ÿ�� ������
	Double nicotine;			//����ƾ ������
	Double quantity;			//����
	Long price;					//����
	int commentCnt;				//comment ����
	
	
	public TobaccoVO() {
		this(-1L);
	}
	public TobaccoVO(Long tobaccoId) {
		this.setQuantity(20D);
		this.setPrice(4500L);
		this.setTobaccoId(tobaccoId);
	}
}
