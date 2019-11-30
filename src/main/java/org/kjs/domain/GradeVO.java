package org.kjs.domain;

import lombok.Data;

@Data
public class GradeVO {
	private Long memberId;
	private String email;
	private Long tobaccoId;
	private String tobaccoName;
	private Long score;
}
