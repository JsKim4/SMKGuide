package org.kjs.controller;

import org.kjs.domain.ComponentVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.PageDTO;
import org.kjs.service.ComponentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	//Component Service�� ó��
	private ComponentService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/* �⺻����
	 * url�� ������ type�� ���� table�� ���� �ϸ� insert ����
	 * component�� ���� table �� ������Ҵ� id,name�� �����ϸ�
	 * type,brand,country,company�� �̿� ����
	 * */
	
	
	
	/*
	 * create �� modify��
	 * requestBody�� vo�� �ް� �Ǵµ� vo�ȿ� �ִ� name field �� �����
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
		model.addAttribute("componentType",type);
		return "component/list";
	}
	
	
	
	
	
	/*
	 * url�� type �� page�� ����
	 * 
	@GetMapping(value = "pages/{type}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ComponentPageDTO> getList(@PathVariable("page") int page, @PathVariable("type") String type) {
		ComponentVO vo = new ComponentVO(type);
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<>(service.getList(vo, cri), HttpStatus.OK);
	}

	
	/*
	 * get ��  remove�� ��� url�� ���� type�� id �� �޾� ó����
	 * url�� type �� page�� ����
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
