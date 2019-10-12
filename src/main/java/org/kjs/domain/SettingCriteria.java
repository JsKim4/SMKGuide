package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettingCriteria {
	private String type;		//검색 타입
	private String keyword;		//검색 키워드
	private Long code;
	private Long id;
}
