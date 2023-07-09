package dev.mvc.step02.step02resolvingview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/s02/first-resolving-view-controller")
public class FirstResolvingViewController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("-- /s02/FirstResolvingViewController handleRequest() called");
		
		// Service 클래스 호출해서 요청 로직 처리했다고 가정
		
		// view 페이지로 전달
		ModelAndView mnv = new ModelAndView();
		// 지금은 화면에 출력할 별도의 데이터가 없음
		
		// View 페이지만 지정
		mnv.setViewName("home"); // '/WEB-INF/views/' + home '.jsp' 파일로 전달
		// 접두사, 접미사 경로는 servlet-context.xml 파일에 지정이 되어있음
		
		// 반환 타입이 ModelAndView
		return mnv;
	}
}
