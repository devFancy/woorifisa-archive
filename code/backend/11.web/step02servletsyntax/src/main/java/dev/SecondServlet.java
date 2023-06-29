package main.java.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 1. HttpServlet 상속
 * 2. doGet() 오버라이드
 * 3. sysout("SecondServlet doGet() called")
 */

/*
 * 2. Annotation(@) 기반 맵핑
 * XML을 통한 관리 방식의 번거로움
 * 추상화되고 직관적인 Annotation을 통해 간소화
 * -> @WebServlet Annotation 활용
 * ref. https://javaee.github.io/javaee-spec/javadocs/javax/servlet/annotation/WebServlet.html
 */

@WebServlet(name = "SecondServlet", urlPatterns = "/servlets/second-servlet")
public class SecondServlet extends HttpServlet {
	/*
	 * web.xml의 아래 설정과 동일함
	 * <servlet-name> SecondServlet </servlet-name>
	 * <url-pattern> /servlets/second-servlet </url-pattern>
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet doGet() called");
	}

}
