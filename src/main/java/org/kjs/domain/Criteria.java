package org.kjs.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {			//��� �˻��� ��ü
	private int pageNum;		//��� ������ ��ȣ 
	private int amount;			//�������� ����
	private int startIndex;		//���۹�ȣ

	private String type;		//�˻� Ÿ�� B= brand , T = type, N=country, M = Company
	private String keyword;		//�˻� Ű����
	private String order;
	private Long bId;
	private Long nId;
	private Long mId;
	private Long tId;
	
	public Criteria() {
		this(1, 10);
	}
	
	public void setStartIndex() {
		this.startIndex = (this.getPageNum()-1)*this.getAmount();
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		startIndex = (pageNum - 1) * amount;
	}
	
	public String[] getTypeArr() {
		return type==null ? new String[] {}: type.split("");
	}
	public String getListLink() {				//url parameter ����
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.getPageNum())
				.queryParam("amount",this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword",this.getKeyword());
		
		return builder.toUriString();
	}
	
	public String getListLinkTobacco() {				//url parameter ����
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.getPageNum())
				.queryParam("amount",this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword",this.getKeyword())
				.queryParam("bId", this.getBId())
				.queryParam("nId",this.getNId())
				.queryParam("mId", this.getMId())
				.queryParam("tId",this.getTId());
		
		return builder.toUriString();
	}
}
