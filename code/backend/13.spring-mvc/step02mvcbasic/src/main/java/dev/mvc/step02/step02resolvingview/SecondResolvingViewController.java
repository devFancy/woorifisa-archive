package dev.mvc.step02.step02resolvingview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondResolvingViewController {
	
	// @RequestMapping Annotation 사용
	@RequestMapping(value = "/s02/second-resolving-view-controller", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		
		// ModelAndView 객체 생성
		ModelAndView mnv = new ModelAndView();
		
		// jsp 파일 맵핑
		mnv.setViewName("test");
		
		// 강의 교안의 spring - 8번의 그림의 - 16번 과정에 해당?
		return mnv;
	}
}
