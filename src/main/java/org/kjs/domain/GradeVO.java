package org.kjs.domain;

import lombok.Data;

@Data
public class GradeVO {
	private MemberVO member;
	private TobaccoVO tobacco;
	private Long score;
}
