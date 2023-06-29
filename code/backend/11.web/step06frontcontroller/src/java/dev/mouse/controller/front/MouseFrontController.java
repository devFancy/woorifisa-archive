package java.dev.mouse.controller.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.dev.mouse.controller.Controller;
import java.dev.mouse.controller.MouseInsertController;
import java.dev.mouse.controller.MouseListController;

/*
 * 푸드코드 프론트에서 모든 음식점들의 메뉴를 주문받는 프론트 컨트롤러
 * Web 요청을 받아서 경로에 맞는 하위 컨트롤러(List, insertController 등)로 전달하는 역할
 * servlet으로 되어있어야 - web 요청을 받을 수 있음
 */
@WebServlet(urlPatterns = "/mouse-api/*")
public class MouseFrontController extends HttpServlet {
	
	// controllerMap: 요청된 경로(URL)와 그에 따른 처리를 담당하고 있는 Controller에 대한 정보를 가지고 있는 필드
	/*
	 * localhost:8080/context-path/mouse-api/"mice" -> 전체 Mouse 목록 조회 요청 경로
	 * localhost:8080/context-path/mouse-api/"mice/add" -> 하나의 Mouse 정보 등록 처리 경로
	 */
	private Map<String, Controller> controllerMap = new HashMap<>();

	public MouseFrontController() {
		// System.out.println("MouseFrontController 기본 생성자 호출됨");
		// Map 자료구조 : key , value
		controllerMap.put("/mice", new MouseListController());
		controllerMap.put("/mice/add", new MouseInsertController());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println(path);
		
		// path 에 맞는 controller를 호출시키기
		// - controllerMap.get(path) : key값이 path와 동일한 value값인 controller가 찾아지겠지
		// - controllerMap.get(path).process(request, response) : controller 안에 있는 메소드인 process를 호출 (parameter가 있으면 넣어주고)
		if(!controllerMap.containsKey(path)) {
			throw new IOException();
		} else {
			
			/*
				Controller controller = controllerMap.get(path);
				controller.process(request, response);
				// /mice를 키 값으로 전달할 경우, 그에 해당하는 Controller 구현 클래스 초기화
			*/
			
			controllerMap.get(path).process(request, response);
			// => 각 path에 맞는 controller들의 process라는 method 가 호출 됨
		}
		
	}

}
