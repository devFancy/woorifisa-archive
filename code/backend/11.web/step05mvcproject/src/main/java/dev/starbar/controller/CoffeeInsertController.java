package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.service.CoffeeService;

@WebServlet("/add-coffee")
public class CoffeeInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/addCoffeePage.jsp";
		
		// 경로로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeService service = new CoffeeService();
		
		request.setCharacterEncoding("UTF-8");
		
		String coffeeName = request.getParameter("coffeeName");
		String coffeeSize = request.getParameter("coffeeSize");
		String coffeePrice = request.getParameter("coffeePrice");
		
		service.insertCoffee(coffeeName, coffeeSize, coffeePrice);
		response.sendRedirect("/step05mvcproject/index.jsp");
	}
	
}
