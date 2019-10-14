package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentVO {	//company, country, brand, type ����
	Long id;			// Ÿ�Ժ� ������ȣ
	String name;		// Ÿ�Ժ� �̸�
	String type;		// ��� table �������� ����
	public ComponentVO(String type) {
		this.type = type;
	}
}
