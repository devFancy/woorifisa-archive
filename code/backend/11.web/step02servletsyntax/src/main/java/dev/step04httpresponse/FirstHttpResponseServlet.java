package main.java.dev.step04httpresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "firstHttpResponseServlet", urlPatterns = "/first-response-servlet")
public class FirstHttpResponseServlet extends HttpServlet {

	// GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP응답은 HttpServletResponse 객체가 처리 함
		
		// HTTP 응답 메세지 작성 시 헤더 부분에 기입할 내용
		// 응답은 response 변수를 통해 지정
		
		// 내가 직접 만든 헤더 값을 응답 메세지에 포함
		response.setHeader("custom-header", "");
		
		PrintWriter out = response.getWriter();
		
		// <html></html> 생략
		
		out.print("Hello");
		out.close();
	}
	
}
