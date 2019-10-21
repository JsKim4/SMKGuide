package org.kjs.service;

import org.kjs.domain.AttachVO;
import org.springframework.web.multipart.MultipartFile;

public interface AttachService {
	public AttachVO get(String uuid);
	
	public String register(MultipartFile file,Long tobaccoId);
	
	public void remove(String uuid);
}
