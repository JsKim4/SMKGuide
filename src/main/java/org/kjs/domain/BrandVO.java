package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandVO {	//Tobacco Brand 
	Long brandId;		//브랜드명
	String brandName;	//브랜드이름
}
