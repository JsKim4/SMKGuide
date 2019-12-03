package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {		
	private Long commentId;				
	private TobaccoVO tobacco;			
	private MemberVO member;			
	private String content;				
	private Date cdate;					
}
