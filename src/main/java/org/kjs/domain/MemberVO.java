package org.kjs.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {		
	private Long memberId;			
	private String email;			
	private String password;		
	private String confirmPassword;	
	private String memberName;		
	private String token;			
	private Boolean deleteFlag;		
	private Long permission;		
	private String telephone;		
	private String address;			
	private Date joindate;			
	private Date updatedate;		
	private List<AuthVO> authList;
}
