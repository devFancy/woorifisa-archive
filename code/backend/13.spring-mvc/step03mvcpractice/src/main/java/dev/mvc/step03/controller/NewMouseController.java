package dev.mvc.step03.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.mvc.step03.domain.Mouse;
import dev.mvc.step03.service.MouseService;

// 기존의 MouseController 이후에 개선된 방식

@Controller
@RequestMapping("/new-mouse-api/mice")
public class NewMouseController {
	// MouseService 의존성 주입 코드 작성
	private final MouseService mouseService;

	// 초기화 안하면, nullpointer 오류가 뜨겠쥬
	public NewMouseController(MouseService mouseService) {
		// MouseService mouseService : spring bean이 주입된 상황 = 의존성 추가
		this.mouseService = mouseService;
	}

	// 반환타입이 ModelAndView가 아니라 문자열(String), 파라미터 Model model
	// RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public String getMice(Model model) {
		List<Mouse> mice = mouseService.findAll();

		model.addAttribute("mice", mice); // addAttribute로 mouseList.jsp 에서 사용할 모델 데이터 담기
		return "mouseList"; // 반환타입은 페이지이름
	}

	// register도 동일하게 작성
	@GetMapping(path = "/register")
	public String getMouseRegisterForm() {
		return "mouseRegisterForm"; // xml 파일에서 접두사, 접미사 붙여주기 때문에 파일명만 입력해도 됨
	}

	/*
	 * 기존 방법
	 * 
	 * @RequestMapping(path="add", method = RequestMethod.POST) public ModelAndView
	 * addMouse(HttpServletRequest request)
	 */
	@PostMapping(path = "/add")
	public String addMouse(@RequestParam("name") String name, @RequestParam("country") String country,
			@RequestParam("address") String address, Model model) {
		Mouse mouse = new Mouse(name, country, address);
		mouseService.add(mouse);

		return "redirect:/new-mouse-api/mice";

	}

}
