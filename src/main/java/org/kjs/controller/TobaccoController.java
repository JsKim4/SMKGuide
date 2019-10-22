package org.kjs.controller;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.domain.TobaccoVO;
import org.kjs.service.AttachService;
import org.kjs.service.ComponentService;
import org.kjs.service.TobaccoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@RequestMapping("/tobacco")
@AllArgsConstructor
@Controller
public class TobaccoController {
	TobaccoService service;
	AttachService attachService;
	ComponentService CS;
	
	public void RM(Model model) {
		model.addAttribute("brandList", CS.getRegistList(new ComponentVO("brand")));
		model.addAttribute("companyList", CS.getRegistList(new ComponentVO("company")));
		model.addAttribute("countryList", CS.getRegistList(new ComponentVO("country")));
		model.addAttribute("typeList", CS.getRegistList(new ComponentVO("type")));
	}
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		cri.setStartIndex();
		int total = service.getTotalCount(cri);
		RM(model);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	@PostMapping("/register")
	public String register(TobaccoVO vo, MultipartFile uploadFile,RedirectAttributes rttr) {
		vo.setTobaccoName(vo.getTobaccoName().trim());
		try {
			if(vo.getTobaccoName().length()>0){
				service.register(vo);
				if(uploadFile.getOriginalFilename().trim().length()>0)
					attachService.register(uploadFile, vo.getTobaccoId());
				rttr.addFlashAttribute("result",vo.getTobaccoId());
			}else {
				rttr.addFlashAttribute("result",-1);
			}
		}catch(Exception e) {
			rttr.addFlashAttribute("result",-1);
		}
		return "redirect:/tobacco/list";	
	}

	@GetMapping("/register")
	public void register(Model model) {
		RM(model);
	}

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("tobaccoId") Long tobaccoId, @ModelAttribute("cri") Criteria cri, Model model) {
		RM(model);
		try {
			model.addAttribute("tobacco", service.get(tobaccoId));
		} catch (Exception e) {
			model.addAttribute("result", "fail");
		}
	}

	@PostMapping("/modify")
	public String modify(TobaccoVO vo, @ModelAttribute("cri") Criteria cri,MultipartFile uploadFile, RedirectAttributes rttr) {
		if (service.modify(vo)) {
			if(uploadFile.getOriginalFilename().trim().length()>0)
				attachService.register(uploadFile, vo.getTobaccoId());
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/tobacco/list" + cri.getListLinkTobacco();
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("tobaccoId") Long tobaccoId, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		if (service.remove(tobaccoId)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/tobacco/list" + cri.getListLinkTobacco();
	}
	

}
