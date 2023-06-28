package dev.food.step01servletonly;

// 푸드코트 사장(서버)
public class Owner {

	// 클라이언트로부터 메뉴를 주문받는 부분
	public String receiveMyOrder(String foodName, String memo) {
		
		// 손님으로부터 받은 음식 메뉴 정보를 추출, 확인
		String orderedMenu = foodName; // request.getParameter("name");
		
		String food = null; // 사장이 만든 요리를 담을 그릇
		
		// 주문받은 음식 제조 - out.print() 를 통해 HTML 태그를 작성하는 부분
		if(orderedMenu.equals("짜파게티")) { // 주문받은 요리가 짜파게티일 경우
			food = "" + 
					"<plate>\n"
					+ "~~~\n" 
					+ "~~~\n" 
					+ "~~~\n" 
					+"</plate>";
		}
		
		// 홀 서빙 - 작성된 HTML을 응답하는 부분 - 응답 객체 전송 
		return food;
		
	}

}
