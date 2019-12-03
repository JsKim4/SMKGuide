package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmokelogVO {		
	private Long smokelogId;			
	private TobaccoVO tobacco;			
	private MemberVO member;			
	private Date cdate;					
}
