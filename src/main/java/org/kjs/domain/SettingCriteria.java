package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettingCriteria {
	private String type;		//�˻� Ÿ��
	private String keyword;		//�˻� Ű����
	private Long code;
	private Long id;
}
