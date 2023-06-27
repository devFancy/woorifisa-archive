package dev.syntax.step02servletprocess;

import java.io.IOException;

/*
 * Q. javax 는 어디서 오는 거지?
 * A. tomcat 설치하면서, 라이브러리 server runtime 에 servlet-api 에서 javax 패키지들이 존재
 */
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 1. HttpServlet 상속
 * 2. 경로 맵핑
 * 3. doGet(), protected service(), init() 2개, destory(), 기본 생성자
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {

	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet() called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() called ");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() called, 사용자 요청에 따라 서비스 제공");
		super.service(req, resp);
	}

	// 서블릿의 코드가 수정되어 새롭게 컴파일되었을 때 기존의 서블릿 인스턴스가 제거됨
	@Override
	public void destroy() {
		System.out.println("destroy() called !!!, 서블릿 인스턴스 제거");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() called, 서블릿 인스턴스 초기화");
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig) called, 서블릿 인스턴스 초기화");
		super.init(config);
	} 
	
	
	/*
	 * 
	 * << 콘솔 >>
	 
	 	<< 맨 처음 페이지 로드 >>
	 	LifeCycleServlet() called
		init(ServletConfig) called, 서블릿 인스턴스 초기화
		init() called, 서블릿 인스턴스 초기화
		service() called, 사용자 요청에 따라 서비스 제공
		doGet() called 
		
		<< 새로고침 >>
		
		service() called, 사용자 요청에 따라 서비스 제공
		doGet() called 
		
		<< 해당 파일 수정 후 저장 - 기존의 인스턴스가 제거 된다. >>
		
		6월 22, 2023 10:18:31 오전 org.apache.catalina.core.StandardContext reload
		정보: 이름이 [/step02servletsyntax]인 컨텍스트를 다시 로드하는 작업이 시작되었습니다.
		
		
		destroy() called, 서블릿 인스턴스 제거
		
		
		6월 22, 2023 10:18:32 오전 org.apache.catalina.core.StandardContext reload
		정보: 이름이 [/step02servletsyntax]인 컨텍스트를 다시 로드하는 것을 완료했습니다.
		
	 */

}

