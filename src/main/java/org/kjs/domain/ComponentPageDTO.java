package org.kjs.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentPageDTO {
	private PageDTO page;			//comment 개수
	private List<ComponentVO> list;		// Tobacco 1개당 list개수
}
