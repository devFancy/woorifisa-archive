package dev.syntax.step06statemanaging.step02session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

		// 로그아웃 처리
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			// getSession(false) : 
			// => HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 생성하지 않고 그냥 null을 반환
			HttpSession session = req.getSession(false);
			
			// 로그인이 되어있는 상태라면, ( = 세션이 있고, id에 값이 있다면 )
			if(session != null && session.getAttribute("id") != null) {
				session.invalidate(); // session 정보 날림
				out.print("로그아웃 완료");
			} else {
				out.print("로그인 상태가 아닙니다.");
			}
			
			out.close(); // 자원 반납
		}
	
}
