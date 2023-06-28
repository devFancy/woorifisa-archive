package dev.syntax.step06statemanaging.step01cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read-cookie")
public class ReadCookieServlet extends HttpServlet {

	// doGet()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		Cookie[] list = req.getCookies();
		for(Cookie cookie : list) {
			out.printf("%s : %s", cookie.getName(), cookie.getValue() + "<br>");
		}
		
		out.close();
	}
	
	
	
}
