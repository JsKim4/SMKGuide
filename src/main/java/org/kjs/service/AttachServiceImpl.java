package org.kjs.service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.kjs.controller.HomeController;
import org.kjs.domain.AttachVO;
import org.kjs.domain.TobaccoVO;
import org.kjs.mapper.AttachMapper;
import org.kjs.mapper.TobaccoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;
import net.coobird.thumbnailator.Thumbnailator;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

@Service
public class AttachServiceImpl implements AttachService {

	@Setter(onMethod_ = @Autowired)
	TobaccoMapper tmapper;
	@Setter(onMethod_ = @Autowired)
	AttachMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Override
	public AttachVO get(String uuid) {
		return mapper.get(uuid);

	}

	@Override
	@Transactional
	public String register(MultipartFile file, Long tobaccoId) {
		File f = new File("file");
		File rootPath = f.getAbsoluteFile();
		 String uploadFolder = rootPath.getPath();
		//String uploadFolder = "C:\\upload\\";
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		AttachVO vo = new AttachVO();
		String uploadFileName = file.getOriginalFilename();
		uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
		vo.setFileName(uploadFileName);
		UUID uuid = UUID.randomUUID();
		uploadFileName = uuid.toString() + "_" + uploadFileName;
		try {
			File saveFile = new File(uploadPath, uploadFileName);

			/*
			 * if(!checkImageType(saveFile)) { return null; }
			 */

			file.transferTo(saveFile);

			vo.setUploadPath(uploadFolderPath);
			vo.setUuid(uuid.toString());

			FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "S_" + uploadFileName));

			Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 50, 50);
			thumbnail.close();
			vo.setTobaccoId(tobaccoId);
			mapper.insert(vo);
			tmapper.updateProfileImg(vo);
			return uuid.toString();
		} catch (Exception e) {
		}
		return vo.getUuid() + "    " + vo.getTobaccoId() + "         " + vo.getFileName() + "        "
				+ vo.getUploadPath();
	}

	@Transactional
	@Override
	public void remove(String uuid) {
		File f = new File("file");
		File rootPath = f.getAbsoluteFile();
		 String uploadFolder = rootPath.getPath();
		//String uploadFolder = "C:\\upload\\";
		AttachVO vo = mapper.get(uuid);
		if (vo != null) {
			String path = uploadFolder+vo.getUploadPath() + "\\" + vo.getUuid() + "_" + vo.getFileName();
			String pathS = uploadFolder+vo.getUploadPath() + "\\S_" + vo.getUuid() + "_" + vo.getFileName();
			try {
				Path removeFile = Paths.get(path);
				Files.deleteIfExists(removeFile);
				removeFile= Paths.get(pathS);
				Files.deleteIfExists(removeFile);
			} catch (Exception e) {
				log.info(e.toString());
			}
		}
		mapper.delete(uuid);
		tmapper.updateProfileImg(null);

	}

	@Transactional
	@Override
	public void upadte(MultipartFile file, Long tobaccoId) {
		TobaccoVO vo = tmapper.get(tobaccoId);
		remove(vo.getAttach().getUuid());
		register(file, tobaccoId);

	}

	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		Magic magic = new Magic();
		try {
			MagicMatch match = magic.getMagicMatch(file, false);
			return match.getMimeType().contains("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
