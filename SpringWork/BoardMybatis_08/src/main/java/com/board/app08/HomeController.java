package com.board.app08;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.dto.BoardDTO;
import com.board.dto.PageVO;
import com.board.model.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardService bservice;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@GetMapping("insert")
	public String insert(HttpSession session) {
		if(session.getAttribute("sMember")==null) {
			return"member/login";
		}
		return "boardInsert";
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}
	
	@GetMapping({"/","list"})
	public String list(Model model,String pageNum,
			@RequestParam(name = "field",defaultValue="")String field,
			@RequestParam(name = "word",defaultValue="")String word) {
		
		int currentPage = pageNum == null?1:Integer.parseInt(pageNum);
		int pageSize = 5;
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("pageStart",(currentPage-1)*pageSize);
		hm.put("pageSize", pageSize);
		
		model.addAttribute("boards",bservice.findAll(hm));
		int count = bservice.getCount(hm);
		model.addAttribute("count",count);
		PageVO page = new PageVO(count,currentPage,pageSize);
		page.setField(field);
		page.setWord(word);
		model.addAttribute("p",page);
		model.addAttribute("rowNo",count-((currentPage-1)*pageSize));
		return "boardlist";
	}
	
	@GetMapping("view/{num}")
	public String view(@PathVariable int num,Model model) {
		model.addAttribute("board",bservice.findByNum(num));
		return "view";
	}
	
	@GetMapping("update/{num}")
	public String update(@PathVariable int num,Model model) {
		model.addAttribute("board",bservice.findByNum(num));
		return "update";
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {
		bservice.update(board);
		return "success";
	}
	
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		bservice.delete(num);
		return "success";
	}
	
}
