package dev.apple;

import dev.apple.controller.AppleController;
import dev.apple.io.Console;

public class AppleStore {
	
	public static void main(String[] args) {
		/*
		 * - 애플 테이블 생성
		 * 
		 * ------------------------------------------------------------
		 * - id / category / price / color / release_date
		 * -    / 아이폰 / 150만원 / 실버 / 2023-07-11
		 * -    / 맥북 / 300만원 / 스페이스그레이 / 2023-07-30
		 * -    / 비전프로 / 500만원 / 블랙 / 2024-01-01
		 * ------------------------------------------------------------
		 * 
		 * --> 1. 전체항목 조회
		 * 	--> select
		 * 
		 * --> 2. 구매
		 * 	--> 특정 id select
		 *  
		 *  
		 * --> 3. 제품 등록 
		 * --> insert
		 * 
		 * --> 4. 제품 삭제
		 * 	--> delete
		 *  
		 * --> 다음에도 이용해주세요 ^^
		 * 
		 */
		
		
		AppleController applecontroller = new AppleController();
		
		
		System.out.println("안녕하세요. apple store 입니다 ~ \n");
		
		// 1. 전체 조회해서 현재 있는 목록들 전체 조회 - findAllApple
		applecontroller.findAllApple();
		
		
		
		// 2. 현재 항목들을 구매 - buyApple
		Console.println("제품을 구매하시겠어요? (할래요 : 1 / 안할래요 : 2)");
		int buyYN = Console.readInt();
		
		if(buyYN == 1) {
			while(true) {
				
				// 전체 조회
				applecontroller.findAllApple();
				
				Console.println("조회할 product id를 입력해주세요.");
				int buyId = Console.readInt();
				applecontroller.buyApple(buyId);
				
				Console.println("더 조회하시겠습니까?(1: 더 볼래요 / 2: 그만 볼래요)");
				int restartOrEndNumber = Console.readInt();
				if(restartOrEndNumber == 2)break;
			}
		}
		
		
		
		// 3. 제품 등록하기 - updateApple
		Console.println("제품을 등록하시겠어요? (할래요 : 1 / 안할래요 : 2)");
		int insertYN = Console.readInt();
		
		if(insertYN == 1) {
			while(true) {
				Console.println("새로 등록할 상품의 카테고리를 입력해주세요.");
				String insertCategory = Console.read();
				
				Console.println("새로 등록할 상품의 가격을 입력해주세요.");
				int insertPrice = Console.readInt();
				
				Console.println("새로 등록할 상품의 색상을 입력해주세요.");
				String insertColor = Console.read();
				
				Console.println("새로 등록할 상품의 출시일을 입력해주세요.");
				String insertReleaseDate = Console.read();
				
				applecontroller.updateApple(insertCategory, insertPrice, insertColor, insertReleaseDate);
				
				// 전체 조회
				applecontroller.findAllApple();
				
				Console.println("제품을 더 등록하시겠습니까?(1: 더 등록할래요 / 2: 그만 등록할래요)");
				int restartOrEndNumber = Console.readInt();
				if(restartOrEndNumber == 2)break;
			}
		}
		
		
		
		// 4. 제품에 문제가 생겨 제품 삭제하기 - deleteApple
		Console.println("제품을 삭제하시겠어요? (할래요 : 1 / 안할래요 : 2)");
		int deleteYN = Console.readInt();
		
		if(deleteYN == 1) {
			while(true) {
				// 제품 전체 조회
				applecontroller.findAllApple();
				
				Console.println("어떤 제품을 삭제하시겠어요? (제품 id를 입력해주세요)");
				int deleteId = Console.readInt();
				
				applecontroller.deleteApple(deleteId);
				
				// 제품 전체 조회
				applecontroller.findAllApple();
				
				Console.println("제품을 더 삭제하시겠습니까?(1: 더 삭제할래요 / 2: 그만 삭제할래요)");
				int restartOrEndNumber = Console.readInt();
				if(restartOrEndNumber == 2) break;
			}
		}
		
		System.out.println("감사합니다. 또 이용해주세요 ~");
	}

}
