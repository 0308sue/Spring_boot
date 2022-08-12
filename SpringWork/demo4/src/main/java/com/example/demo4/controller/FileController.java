package com.example.demo4.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo4.model.FileBoard;
import com.example.demo4.service.FileService;

@Controller
@RequestMapping("/file/*")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("insert")
	public String insert() {
		return"/file/fileboardInsert";
	}
	
	@PostMapping("fileInsert")
	public String insert(FileBoard fboard,HttpSession session) {
		String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources\\img";
		fileService.fileInsert(fboard,uploadFolder);
		return "redirect:/file/fileList";
	}
	
	@GetMapping("fileList")
	public String fileList(Model model) {
		List<FileBoard> files = fileService.fileList();
		model.addAttribute("files", files);
		return"/file/fileList";
	}

}
