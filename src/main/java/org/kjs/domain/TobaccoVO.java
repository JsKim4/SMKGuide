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
	Double amount;				//����
	Long price;					//����
	public TobaccoVO() {
		this.setAmount(20D);
		this.setPrice(4500L);
	}
}
