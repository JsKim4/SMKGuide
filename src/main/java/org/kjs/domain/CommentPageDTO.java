package org.kjs.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPageDTO {
	private PageDTO commentPage;		//comment 개수
	private List<CommentVO> list;		// Tobacco 1개당 list개수
}
