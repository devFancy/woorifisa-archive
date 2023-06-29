package java.dev.mouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MouseInsertController implements Controller {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert controller 가 호출되었습니다.");
		
		// Mouse 데이터 추가 로직
		
		// mouseList.jsp 같은 곳으로 이동
	}

}
