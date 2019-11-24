package org.kjs.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {			//담배 검색용 객체
	private int pageNum;		//담배 페이지 번호 
	private int amount;			//페이지당 갯수
	private int startIndex;		//시작번호

	private String type;		//검색 타입 B= brand , T = type, N=country, M = Company
	private String keyword;		//검색 키워드
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
	public String getListLink() {				//url parameter 생성
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.getPageNum())
				.queryParam("amount",this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword",this.getKeyword());
		
		return builder.toUriString();
	}
	
	public String getListLinkTobacco() {				//url parameter 생성
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
