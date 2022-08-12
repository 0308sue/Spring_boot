package com.example.demo4.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo4.model.FileBoard;
import com.example.demo4.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	private FileRepository filerepository;
	
	public void fileInsert(FileBoard fboard,String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile f = fboard.getUpload();
		
		String uploadFileName="";
		if(!f.isEmpty()) {
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
			File saveFile = new File(uploadFolder,uploadFileName);
			
			try {
				f.transferTo(saveFile);
				fboard.setFileimage(uploadFileName);
				
				filerepository.save(fboard);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<FileBoard> fileList(){
		return filerepository.findAll();
	}
}
