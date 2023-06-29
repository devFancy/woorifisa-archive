package main.java.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Servlet ?
 * 
 * 동적인(dynamic) 요청을 처리할 때 작성하는 Java 파일(.java)
 * Servlet을 구현을 하기 위해서는 'HttpServlet'이라는 클래스를 상속(extends)받으면 됨
 * 
 * 1. XML 기반 맵핑(web.xml)
 * - <servlet> : 서블릿 객체 맵핑
 * 		<servlet-name> : 서블릿 이름
 * 		<servlet-class> : 서블릿 클래스명(패키지명 포함 풀네임)
 *   </servlet>
 *   
 * - <servlet-mapping>
 * 		<servlet-name> : 서블릿 이름
 * 		<url-pattern> : 서블릿이 동작할 url 주소
 * 	 </servlet-mapping>
 */

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do Get");
	}
	
}
