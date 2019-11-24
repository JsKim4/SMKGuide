package org.kjs.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoVO {
	Long infoId;
	String title;
	String content;
	String name;
	String board;
	Date cdate;
}
