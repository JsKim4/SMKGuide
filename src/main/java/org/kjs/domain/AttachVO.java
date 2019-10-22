package org.kjs.domain;

import lombok.Data;

@Data
public class AttachVO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	
	private Long tobaccoId;
	
	public String getAttachFileName() {
		if(uuid!=null&&uuid.length()>0) {
			return this.uploadPath.replace("\\", "/")+"/"+this.uuid+"_"+this.fileName;
		}
		return "";
	}
}
