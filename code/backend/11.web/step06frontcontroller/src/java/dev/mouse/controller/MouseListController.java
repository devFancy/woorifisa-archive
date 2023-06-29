package java.dev.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 일식집 매장
public class MouseListController implements Controller {
	
	// 기존 방식
	// 1. HttpServlet 상속
	// 2. doGet, doPost 중 구현

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("list controller 가 호출되었습니다.");
		
	}
	
	
	
}
