package dev.food.step01servletonly;

public class FoodCourtDay1 {

	// 푸드코트 오픈 1일차!
	public static void main(String[] args) {
		
		// 사장 객체 생성(서버)
		Owner owner = new Owner();
		
		// 손님 객체 생성(클라이언트)
		Client client = new Client();
		
		// 음식 주문(서버에 요청 전송) - HTTP 요청 전송
		String myFood = client.requsetMessage(owner, "짜파게티");
		
		// 완성된 요리를 손님이 전달 받음(서버로부터의 응답)
		System.out.println(myFood + "\n냠냠");
	}

}
