package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmokelogVO {		//���α�
	Long smokelogId;			//���α� ������ȣ
	TobaccoVO tobacco;			//�� ���
	Long memberId;				//�� �����
	Date cdate;					//����
}
