package org.kjs.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPageDTO {
	private int commentCount;			//comment ��ü ����
	private List<CommentVO> list;		// Tobacco 1���� list����
}
