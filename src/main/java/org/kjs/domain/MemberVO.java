package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {		//�����
	Long memberId;			//����� ������ȣ
	String email;			//����� �̸���
	String password;		//����� ��й�ȣ
	String confirmPassword;	//Ȯ�� Ȥ�� ����� ��й�ȣ
	String memberName;		//����� �̸�
	String token;			//��ū
	Boolean deleteFlag;		//��������
	Long permission;		//���� ����
	String telephone;		//��ȭ��ȣ
	String address;			//�ּ�
	Date joindate;			//������
	Date updatedate;		//������
}
