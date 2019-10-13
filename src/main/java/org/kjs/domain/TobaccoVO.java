package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TobaccoVO {		//담배
	Long tobaccoId;				//담배고유번호
	String tobaccoName;			//담배이름
	Boolean deleteFlag;			//삭제여부
	ComponentVO country;		//국가
	ComponentVO company;		//회사
	ComponentVO type;			//타입
	ComponentVO brand;			//브랜드
	Double tar;					//타르 함유량
	Double nicotine;			//니코틴 함유량
	Double amount;				//갯수
	Long price;					//가격
}
