package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
