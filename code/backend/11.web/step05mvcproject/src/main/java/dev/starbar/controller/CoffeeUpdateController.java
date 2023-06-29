package main.java.dev.starbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dev.starbar.model.Coffee;
import main.java.dev.starbar.service.CoffeeService;

@WebServlet("/update-coffee")
public class CoffeeUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String updateId = request.getParameter("id");
		
		CoffeeService service = new CoffeeService();
		Coffee coffee = service.findOne(updateId);
		
		request.setAttribute("menu", coffee);
		
		// JSP 경로 지정 
		final String path = "/WEB-INF/editPage.jsp";
		
		// 4-3. 실제 경로로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeService service = new CoffeeService();
		
		request.setCharacterEncoding("UTF-8");
		
		String coffeeId = request.getParameter("coffeeId");
		String coffeeName = request.getParameter("coffeeName");
		String coffeeSize = request.getParameter("coffeeSize");
		String coffeePrice = request.getParameter("coffeePrice");
		
		service.updateCoffee(coffeeId, coffeeName, coffeeSize, coffeePrice);
		response.sendRedirect("/step05mvcproject/index.jsp");
	}

}
