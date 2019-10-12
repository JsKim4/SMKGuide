package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyVO { //Tobacco Company
	Long companyId;		//제조사 번호
	String companyName;	//제조사 이름
}
