package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {		//사용지
	Long memberId;			//사용자 고유번호
	String email;			//사용자 이메일
	String password;		//사용자 비밀번호
	String confirmPassword;	//확인 혹은 변경용 비밀번호
	String memberName;		//사용자 이름
	String token;			//토큰
	Boolean deleteFlag;		//삭제여부
	Long permission;		//권한 레벨
	String telephone;		//전화번호
	String address;			//주소
	Date joindate;			//가입일
	Date updatedate;		//수정일
}
