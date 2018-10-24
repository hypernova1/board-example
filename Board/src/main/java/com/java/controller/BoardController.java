package com.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.domain.BoardVO;
import com.java.domain.Criteria;
import com.java.domain.PageMaker;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService service;
	
	@GetMapping("/register")
	public String registerGet(BoardVO board, Model model) {
		logger.info("register Get...");
		
		return "board/register";
	}
	
	@PostMapping("/register")
	public String registerPost(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		logger.info("register Post...");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "success");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/board/listPage";
	}
	
	@GetMapping("/readPage")
	public void readPage(Integer bno, Criteria cri, Model model) {
		model.addAttribute(service.read(bno));
		model.addAttribute("cri", cri);
	}
	
	@GetMapping("/removePage")
	public String remove(Integer bno, Criteria cri, RedirectAttributes rttr) {
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/board/listPage";
		
	}
	
	@GetMapping("/modifyPage")
	public void modifyGet(Integer bno, Criteria cri, Model model) {
		model.addAttribute(service.read(bno));
		model.addAttribute("cri", cri);
	}
	
	@PostMapping("/modifyPage")
	public String modifyPost(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		System.out.println("qdd:" + vo.getBno());
		
		logger.info("mod post.....");
		
		service.modify(vo);
		rttr.addFlashAttribute("msg", "success");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/board/listPage";
	}
	
	@GetMapping("/listPage")
	public void listCri(Criteria cri, Integer bno, Model model) {
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pm);
	}
}