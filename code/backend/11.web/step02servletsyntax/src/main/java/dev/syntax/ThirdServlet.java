package dev.syntax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/third-servlet")
public class ThirdServlet extends HttpServlet {
	
	// 직렬화 관련
	private static final long serialVersionUID = 1L;
	/**
	 * Java의 직렬화(serialization)와 관련된 클래스에서 발생하는 경고 메시지
	 * 직렬화는 객체를 바이트 스트림으로 변환하여 저장하거나 전송할 수 있게 해주는 기능
	 * 이때 직렬화된 객체를 역직렬화(deserialization)하여 다시 원래의 객체로 변환할 수 있음
	 * Java에서 직렬화된 객체를 역직렬화할 때, 
	 * 클래스의 버전 관리를 위해 serialVersionUID라는 정적(static) 필드를 사용하는데,
	 * 이 필드는 long 타입이며, 클래스의 구조나 멤버 변수 등이 변경되었을 때 버전 충돌을 방지하기 위해 사용됨
	 */
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("third called!");
		
		// 응답 헤더에 이 문서의 타입은 HTML 파일임을 명시
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
			out.println("<head>");
				out.println("<title>Hello World!</title>");
			out.println("</head>");
			
			out.println("<body>");
				out.println("<h1>Hello World!</h1>");
			out.println("</body>");
		
		out.println("</html>");
		
	}

}
