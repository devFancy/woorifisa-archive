package dev.mouse;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.domain.Mouse;
import dev.mouse.repository.MouseDAO;

@WebServlet("/mice/add")
public class MouseInsertServlet extends HttpServlet {
	
	Logger logger = Logger.getLogger("MouseRegisterFormServlet");

	private MouseDAO mouseDAO;
	
	public MouseInsertServlet() {
		this.mouseDAO = new MouseDAO();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("-- Entering MouseInsertSErvlet");
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseDAO.add(newMouse);
		
		String path = "/mice";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
		response.sendRedirect("/step03servletpractice/mice");
	}
	
}
