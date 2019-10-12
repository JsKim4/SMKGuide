package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {		//담배의 comment
	Long commentId;				//코멘트 고유번호
	TobaccoVO tobacco;			//작성된 담배
	MemberVO member;			//작성 사용자
	String content;				//내용
	Date cdate;					//작성일
}
