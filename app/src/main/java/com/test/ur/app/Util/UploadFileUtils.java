package com.test.ur.app.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.ur.app.constants.URConstants;

public class UploadFileUtils {
	
	@Resource(name = "uploadPath")
	private static String uploadPath;

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(MultipartFile file) throws Exception {
		
		logger.info("File upload start");
		
		System.out.println(uploadPath);
		
		String path = "";
		if (uploadPath == null) {
			path = URConstants.IMAGE_UPLOAD_PATH;
		} else {
			path = uploadPath;
		}
		
		StringBuffer sb = new StringBuffer(path);
		sb.append(File.separator);
		sb.append(DateFormat.dateToString(URConstants.DATE_FORMAT_02));
		String savePath = sb.toString();
					
		File dir = new File(savePath);
	
		// �粕��駕���ｦｬ ��晧┳
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		
		// �寳�ｳｸ 甯護攵 �擽�ｦ�
		String originalName = file.getOriginalFilename();
        
        // 甯護攵 嶹菩棗�梵 �ｷｨ�統
        String ext = originalName.substring(originalName.lastIndexOf(".")).toUpperCase();
	
        // ����棗﨑� 甯護攵 �擽�ｦ�
        String saveFileName = UUID.randomUUID().toString().replace("-", "") + ext.toLowerCase();

        // 甯護攵 ����棗 �ｲｽ�｡�
        String saveFilePath = savePath + File.separator + saveFileName;
		
		try {
            File target = new File(saveFilePath);
			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(target));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		logger.info("File upload end");
		
		return saveFilePath;
	}	
}
