package com.part3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.part3.domain.BoardVO;
import com.part3.domain.Criteria;
import com.part3.domain.pageDTO;
import com.part3.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list");
//		
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list :: {}", cri);
		model.addAttribute("list", service.getList(cri));
		int total = service.getTotal(cri);
		log.info("total :: {}", total);
		
		model.addAttribute("pageMaker", new pageDTO(cri, 123));
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register :: {}", board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify: {}", board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		/* UriComponentsBuiilder를 쓰지 않을 경우
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		*/
		
		/*UriComponentsBuiilder 적용시*/
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		log.info("remove: {}", bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		/* UriComponentsBuiilder를 쓰지 않을 경우
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		*/
		
		/*UriComponentsBuiilder 적용시*/
		return "redirect:/board/list" + cri.getListLink();
	}
}
