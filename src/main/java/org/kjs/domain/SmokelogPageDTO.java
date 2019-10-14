package org.kjs.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmokelogPageDTO {
	private PageDTO smokelogPage;			//smoke log 개수
	private List<SmokelogVO> list;		// Tobacco 1개당 or user 한명당 list
}
