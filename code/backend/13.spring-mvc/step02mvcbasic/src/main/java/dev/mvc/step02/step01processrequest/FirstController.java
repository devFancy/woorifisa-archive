package dev.mvc.step02.step01processrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// FirstController.java를 /step02/s01/first-controller 경로로 지정하여 스프링 빈으로 등록
// http://localhost:8080/step02/s01/first-controller로 테스트
@Component(value = "/s01/first-controller") // bean 으로 등록
public class FirstController implements Controller {
	
	// controller 인터페이스 구현
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("-- /step02/first-controller handlerRequest() called");
		
		return null;
	}
	
}