package dev.food.step01servletonly;

// 음식점 손님(웹 브라우저, 클라이언트)
public class Client {

	// 짜파게티 요리 주문 요청 API
	public String requsetMessage(Owner owner, String foodName) {
		
		// 사장에게 주문 하기(실제 request 전송)
		String myFood = owner.receiveMyOrder(foodName , "-");
		
		return myFood;
	}

}
