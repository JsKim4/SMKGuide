package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {		//����� comment
	Long commentId;				//�ڸ�Ʈ ������ȣ
	TobaccoVO tobacco;			//�ۼ��� ���
	MemberVO member;			//�ۼ� �����
	String content;				//����
	Date cdate;					//�ۼ���
}
