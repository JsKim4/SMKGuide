package org.kjs.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {		//사용지
	private Long memberId;			//사용자 고유번호
	private String email;			//사용자 이메일
	private String password;		//사용자 비밀번호
	private String confirmPassword;	//확인 혹은 변경용 비밀번호
	private String memberName;		//사용자 이름
	private String token;			//토큰
	private Boolean deleteFlag;		//삭제여부
	private Long permission;		//권한 레벨
	private String telephone;		//전화번호
	private String address;			//주소
	private Date joindate;			//가입일
	private Date updatedate;		//수정일
	private List<AuthVO> authList;
}
