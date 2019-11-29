package org.kjs.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {		//�����
	private Long memberId;			//����� ������ȣ
	private String email;			//����� �̸���
	private String password;		//����� ��й�ȣ
	private String confirmPassword;	//Ȯ�� Ȥ�� ����� ��й�ȣ
	private String memberName;		//����� �̸�
	private String token;			//��ū
	private Boolean deleteFlag;		//��������
	private Long permission;		//���� ����
	private String telephone;		//��ȭ��ȣ
	private String address;			//�ּ�
	private Date joindate;			//������
	private Date updatedate;		//�����
	private List<AuthVO> authList;
}
