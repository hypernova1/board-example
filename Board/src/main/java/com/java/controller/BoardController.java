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
	public String registerPost(BoardVO board, RedirectAttributes rttr) {
		logger.info("register Post...");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
	
	@GetMapping("/listAll")
	public void listAll(String msg, Model model) {
		logger.info("show all list.....");
		model.addAttribute("list", service.listAll());
	}
	
	@GetMapping("/read")
	public void read(int bno, Model model) {
		model.addAttribute(service.read(bno));
	}
	
	@GetMapping("/remove")
	public String remove(Integer bno, RedirectAttributes rttr) {
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
		
	}
	
	@GetMapping("/modify")
	public void modifyGet(Integer bno, Model model) {
		model.addAttribute(service.read(bno));
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardVO vo, RedirectAttributes rttr) {
		
		logger.info("mod post.....");
		
		service.modify(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
}