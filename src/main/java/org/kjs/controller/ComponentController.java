package org.kjs.controller;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.service.ComponentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/component")
@Controller
@Slf4j
@AllArgsConstructor
public class ComponentController {
	//Component Service로 처리
	private ComponentService service;
	
	/* 기본골자
	 * url로 들어오는 type에 따라 table을 변경 하며 insert 실행
	 * component로 묶인 table 의 구성요소는 id,name만 존재하며
	 * type,brand,country,company가 이에 속함
	 * */
	
	
	
	/*
	 * create 와 modify는
	 * requestBody로 vo를 받게 되는데 vo안에 있는 name field 만 사용함
	 * */
	
	/*@PostMapping("/{type}/register")
	public String register(ComponentVO vo,@PathVariable("type") String type, RedirectAttributes rttr) {
		vo.setType(type);
		try {
			if(vo.getName().length()>0){
				service.register(vo);
				rttr.addFlashAttribute("result",vo.getId());
				return "redirect:/component/"+type+"/list";	
			}
		}catch(Exception e) {}
		rttr.addFlashAttribute("result",-1);
		return "redirect:/component/"+type+"/list";	
	}
	
	@PostMapping("/{type}/modify")
	public String modify(ComponentVO vo, @ModelAttribute("cri") Criteria cri,@PathVariable("type") String type, RedirectAttributes rttr) {
		if (service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/component"+type+"/list" + cri.getListLink();
	}
	*/
	@GetMapping("/{type}/list")
	public String list(Model model, Criteria cri,@PathVariable("type") String type) {
		ComponentVO vo = new ComponentVO(type);
		cri.setStartIndex();
		int total = service.getTotalCount(vo,cri);
		model.addAttribute("list", service.getList(vo, cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		return "component/list";
	}
	
	
	
	
	
	/*
	 * url로 type 과 page를 받음
	 * 
	@GetMapping(value = "pages/{type}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type) {
		ComponentVO vo = new ComponentVO(type);
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<>(service.getList(vo, cri), HttpStatus.OK);
	}

	
	/*
	 * get 과  remove의 경우 url을 통해 type과 id 만 받아 처리함
	 * url로 type 과 page를 받음
	 * 
	
	@GetMapping(value = "/{type}/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentVO> get(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return new ResponseEntity<>(service.get(vo), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{type}/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("type") String type, @PathVariable("id") Long id) {
		ComponentVO vo = new ComponentVO(id, "", type);
		return service.remove(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 */

}
