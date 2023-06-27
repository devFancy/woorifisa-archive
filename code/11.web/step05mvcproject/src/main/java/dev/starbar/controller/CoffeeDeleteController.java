package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/delete-coffee")
public class CoffeeDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/deletePage.jsp";
		
		// 경로로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeService service = new CoffeeService();
		
		String delId = request.getParameter("delId");
		System.out.println(delId);
		
		service.deleteCoffee(delId);
		response.sendRedirect("/step05mvcproject/index.jsp");
		
	}
	
}
