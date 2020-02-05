package com.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.domain.BoardVO;
import com.java.domain.PageMaker;
import com.java.domain.SearchCriteria;
import com.java.service.BoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {

	private static Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") SearchCriteria cri, Model model) {
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		
		pm.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pm);
	}
	
	@GetMapping("/readPage")
	public void read(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute(service.read(bno));
	}
	
	@PostMapping("/removePage")
	public String remove(int bno, SearchCriteria cri, RedirectAttributes rttr) {
		
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/aboard/list";
	}
	
	@GetMapping("/modifyPage")
	public void modifyPageGet(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		System.out.println(cri.getPage());
		model.addAttribute(service.read(bno));
	}
	
	@PostMapping("/modifyPage")
	public String modifyPagePost(BoardVO vo, SearchCriteria cri, RedirectAttributes rttr) {
		logger.info(cri.toString());
		service.modify(vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", cri.getKeyword());
		
		logger.info(rttr.toString());
		return "redirect:/sboard/list";
	}
	
	@GetMapping("/register")
	public void registGet() {
		logger.info("regist get....");
	}
	
	@PostMapping("/register")
	public String registPost(BoardVO vo, RedirectAttributes rttr) {
		logger.info("register post....");
		
		service.regist(vo);
		
		rttr.addFlashAttribute("msg", "Success");
		
		return "redirect:/sboard/list";
	}
}
