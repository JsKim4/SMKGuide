package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryVO { //Tobacco Country
	Long countryId;		//제조국 db저장번호
	Long countryCode;	//제조국 국가 번호
	String countryName;	//제조국 이름
}
