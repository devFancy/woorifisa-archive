package dev.syntax.step02servletprocess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet 으로 동작할 수 있도록 작성
 * 
 * 1. doGet()
 * 2. service() 2개 오버라이딩
 * 
 * 동작하는지 URL 맵핑해서 확인 경로는  /ProcessServlet으로 지정 후 서버 실행, 동작 실행
 * 
 */

@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {

	// 기본 생성자
	public ProcessServlet() {
		
		// 사용자 요청 시 인스턴스가 생성됨(브라우저를 새로고침해도 인스턴스가 재생성되지 않음)
		System.out.println("ProcessServlet() called");
		/*
			Servlet은 싱글톤 패턴으로 동작한다.
			매번 new를 통해 새로 생성해서 만들고 있지 않다.
		*/
	}

	
	// 일반 경로ㅡ doGet()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doGet() 호출 됨");
		
	}

	
	// 표준 HTTP Request를 public service()로부터 전달 받아서 doXxx() 호출(ex. doGet())
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("protected service() called");
		super.service(req, resp);
	}

	
	// service()
	// 클라이언트의 외부 request 를 protected service()에게 전달
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("public service() called");
		super.service(req, res);
	}

	
	/*
		ProcessServlet() called
		public service() called
		protected service() called
		doGet() 호출 됨
		
		-> 다시 새로 고침 시, 인스턴스가 재생성 되지 않음
		-> 최초 요청이 아니므로
		public service() called
		protected service() called
		doGet() 호출 됨
	 */

}
