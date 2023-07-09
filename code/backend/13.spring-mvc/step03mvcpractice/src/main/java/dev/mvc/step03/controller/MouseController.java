package dev.mvc.step03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.step03.domain.Mouse;
import dev.mvc.step03.service.MouseService;


// 루트 경로는 "/mouse-api/mice"로 받을 수 있도록 클래스 레벨에 경로 지정

@Controller
@RequestMapping(value = "/mouse-api/mice")
public class MouseController {
	
	// 의존성 주입 !
	private final MouseService mouseService;
	
	@Autowired
	public MouseController(MouseService service) {
		this.mouseService = service;
	}

	// 전체 Mouse List 출력하는 메서드, 경로명: 루트 경로와 동일, 페이지명: mouseList.jsp 작성
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMice(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mnv = new ModelAndView();
		List<Mouse> mice = mouseService.findAll();
		
		mnv.addObject("mice", mice);
		mnv.setViewName("mouseList");
		
		return mnv;
	}
	
	// Mouse 등록 폼을 출력하는 메서드, 경로명: /register 페이지명: mouseRegisterForm.jsp
	@RequestMapping(value = "register")
	public ModelAndView getMouseRegisterForm() {
		
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("mouseRegisterForm");
		
		return mnv;
	}
	
	// Mouse 등록 처리 메서드, 경로명 /add, 페이지명: mouse 전체 목록 화면으로 리다이렉트하기
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView addMouse(HttpServletRequest request) {
		
		ModelAndView mnv = new ModelAndView();
		String name = request.getParameter("name");
		String country = request.getParameter("name");
		String address = request.getParameter("name");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseService.add(newMouse);
		
		mnv.setViewName("redirect:/mouse-api/mice");
		
		return mnv;
	}
	
	
}
