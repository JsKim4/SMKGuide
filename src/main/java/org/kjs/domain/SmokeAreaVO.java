package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmokeAreaVO {
	private Long areaId;
	private String areaName;
	private double latitude;
	private double longitude;
}
