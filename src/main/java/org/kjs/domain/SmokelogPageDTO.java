package org.kjs.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmokelogPageDTO {
	private PageDTO smokelogPage;			//smoke log ����
	private List<SmokelogVO> list;		// Tobacco 1���� or user �Ѹ�� list
}
