package org.kjs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TobaccoVO {		
	private Long tobaccoId;				
	private String tobaccoName;			
	private Boolean deleteFlag;			
	private ComponentVO country;		
	private ComponentVO company;		
	private ComponentVO type;			
	private ComponentVO brand;			
	private Double tar;					
	private Double nicotine;			
	private Double quantity;			
	private Long price;					
	private int commentCnt;				
	private AttachVO attach;
	private Long gradeSum;
	private Long gradeNum;
	public TobaccoVO() {
		this(-1L);
	}
	public TobaccoVO(Long tobaccoId) {
		this.setQuantity(20D);
		this.setPrice(4500L);
		this.setTobaccoId(tobaccoId);
	}
}
