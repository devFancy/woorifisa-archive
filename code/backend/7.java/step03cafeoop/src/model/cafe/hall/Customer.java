package model.cafe.hall;

// package 잘 보고 import
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Customer {
	private final String nickName;
    private CustomerInfo customerInfo;
    private int balance; // 잔액
    
    
    // 손님의 메뉴 조회
    public void checkMenu() {
		Scanner sc = new Scanner(System.in); // inputStream 을 인수로 주기 ~
		
		// 담당 스태프 생성
		
		int isMenuNeeded = sc.nextInt();
		System.out.println(isMenuNeeded);
	}
}
