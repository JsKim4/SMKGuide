package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryVO { //Tobacco Country
	Long countryId;		//������ db�����ȣ
	Long countryCode;	//������ ���� ��ȣ
	String countryName;	//������ �̸�
}
