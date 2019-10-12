package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmokelogVO {		//흡연로그
	Long smokelogId;			//흡연로그 고유번호
	TobaccoVO tobacco;			//흡연 담배
	Long memberId;				//흡연 사용자
	Date cdate;					//흡연일
}
