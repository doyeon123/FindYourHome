package com.test.ur.app.Util;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.test.ur.app.dto.CodeDto;

import au.com.bytecode.opencsv.CSVReader;

public class CsvUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(CsvUtils.class);

	public static List<String[]> convertCsvData(String path, MultipartFile file) throws Exception {
		
		logger.info("ConvertCsvData Start");
		
		List<String[]> allData = new ArrayList<String[]>();
		
		File saveFile = null;
		
		File dir = new File(path); 
        if (!dir.isDirectory()) { 
            dir.mkdirs(); 
        }
        
        path = path + File.separator + file.getOriginalFilename();
        saveFile = new File(path);
        file.transferTo(saveFile);

		try {
			FileReader filereader = new FileReader(path);
			
			@SuppressWarnings("resource")
			CSVReader reader = new CSVReader(filereader, ',', '\'', 1);
			
			allData = reader.readAll();
			
			return allData;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("ConvertCsvData Error : " + e.getLocalizedMessage());
		} finally {
			if (saveFile != null && saveFile.exists()) {
				saveFile.delete();
			}
		}
		
		logger.info("ConvertCsvData End");
		return allData;
	}
}
