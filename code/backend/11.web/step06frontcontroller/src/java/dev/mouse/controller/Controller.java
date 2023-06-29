package java.dev.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	// 요청 경로별 세부 로직처리는 실제 구현 클래스 에서 구현
	void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
	
}
