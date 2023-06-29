package main.java.dev.step05querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-kor")
public class QueryServletKor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		
		// * 인코딩 설정
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html");
		
		// * 인코딩 설정
		// 한 번에 쓸 수 있음
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>GET 방식으로 요청 되었음.</h1>");
		out.print("이름 : " + name + " <br/> ");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식에서의 한글 처리(인코딩)
		// request 객체도 UTF-8로 인코딩 처리해서 보낸다.
		request.setCharacterEncoding("UTF-8"); // 요청 메세지를 UTF-8로 보낸다.
		
		// * 인코딩 설정
		// 한 번에 쓸 수 있음
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		System.out.println(name); // request할 때도 인코딩 처리를 해야, 콘솔이 정상적으로 찍힘
		
		PrintWriter out = response.getWriter();
		out.print("<h1>GET 방식으로 요청 되었음.</h1>");
		out.print("이름 : " + name + " <br/> ");
		
		out.close();
	}

}
