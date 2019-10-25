package org.kjs.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.kjs.service.AttachService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class AttachController {
	AttachService attachService;
	

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {
		//File f = new File("file");
		//File rootPath = f.getAbsoluteFile();
		//File file = new File(rootPath.getPath()+"/"+ fileName);
		File file = new File("C:\\upload\\" + fileName);
		if(fileName==null||fileName.length()<1)
			return null;

		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
