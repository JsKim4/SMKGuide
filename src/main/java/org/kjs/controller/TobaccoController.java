package org.kjs.controller;

import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.domain.TobaccoVO;
import org.kjs.service.TobaccoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@RequestMapping("/tobacco")
@AllArgsConstructor
@Controller
public class TobaccoController {
	TobaccoService service;
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		cri.setStartIndex();
		int total = service.getTotalCount(cri);
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri,total));
	}
	
	@PostMapping("/register")
	public String register(TobaccoVO vo, RedirectAttributes rttr) {
		service.register(vo);
		rttr.addFlashAttribute("result",vo.getTobaccoId());
		return "redirect:/tobacco/list";	
	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("tobaccoId") Long tobaccoId,
			@ModelAttribute("cri") Criteria cri,
			Model model) {
		try {
			model.addAttribute("tobacco", service.get(tobaccoId));
		} catch (Exception e) {
			model.addAttribute("result","fail");
		}
	}
	
	@PostMapping("/modify")
	public String modify(TobaccoVO vo,@ModelAttribute("cri")Criteria cri,RedirectAttributes rttr) {
		if(service.modify(vo)) {
			rttr.addAttribute("result","success");
		}
		return "redirec:/tobacco/list"+cri.getListLinkTobacco();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("tobaccoId")Long tobaccoId,@ModelAttribute("cri")Criteria cri,RedirectAttributes rttr) {
		if(service.remove(tobaccoId)) {
			rttr.addAttribute("result","success");
		}
		return "redirec:/tobacco/list"+cri.getListLinkTobacco();
	}
	
	
	/*
	 * 	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		log.info("modify : " + board);
		if (boardService.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"+cri.getListLink();
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove....." + bno);
		if (boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/board/list"+cri.getListLink();
	}
*/
}