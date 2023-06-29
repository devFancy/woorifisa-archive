package main.java.dev.starbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dev.starbar.model.Coffee;
import main.java.dev.starbar.service.CoffeeService;

/*
 * Servlet
 * 사용자로부터 GET 요청을 받을 경우 전체 Coffee 목록 데이터를 coffeeList.jsp로 전달
 */
@WebServlet("/coffees")
// 1. Servlet으로 동작하도록 HttpServlet 상속 
public class CoffeeListController extends HttpServlet {
	// http://localhost:8080/step05mvc2practice/coffees 경로로 요청을 전달 받으면
	// 요청에 맞는 Service를 호출 -> findAll()
	// http://localhost:8080/step05mvc2practice/coffees 경로만 보고도
	// 전체 Coffee 데이터를 조회해달라는 요청이라고 이해하면 더 좋음
	
	// 2. GET 요청을 처리하기 위해 호출되는 메서드 오버라이딩
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. DB에서 전체 Coffee 목록 조회하는 요청을 service 클래스에게 전달
		// Controller가 직접 DB에 조회하는 DAO를 호출하지 않음
		CoffeeService service = new CoffeeService();
		List<Coffee> coffees = service.findAll();
		// 전체 커피 데이터 출력해서 잘 출력되는지
		System.out.println(coffees);
		
		// 4. 커피 목록 결과 데이터를 jsp 페이지로 포워딩
		// - MVC에서 View 역할을 담당하는 coffeeList.jsp에게 model 데이터(전체 Coffee 목록)를 전달
		
		// 4-1. 요청 객체 내부에 list라는 이름의 key 값으로 coffess 목록 데이터를 저장
		request.setAttribute("list", coffees);
		
		// 4-2. jsp 페이지 경로 지정
		final String path = "/WEB-INF/coffeeList.jsp";
		
		// 4-3. 실제 경로로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
