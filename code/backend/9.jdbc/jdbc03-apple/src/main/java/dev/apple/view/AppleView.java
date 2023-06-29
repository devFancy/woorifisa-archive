package dev.apple.view;

import java.util.List;

import dev.apple.model.Apple;

public class AppleView {

	// 1. 전체 조회
	public void viewFindAllApple(List<Apple> apples) {
		for (Apple apple : apples) {
			System.out.println(String.format("* 상품 id : %d | 상품 카테고리 : %s | 색상 : %s | 가격 : %d 원 입니다. ", apple.getProductId(),
					apple.getCategory(), apple.getColor(), apple.getPrice()));
		}
		System.out.println("\n");
	}

	// 2. buy
	public void viewBuyApple(Apple apple) {
		System.out.println(String.format("%s %s는 %d는 원 입니다.", apple.getColor(), apple.getCategory(), apple.getPrice()));
	}

	// 3. update
	public void viewUpdateApple(int affectedRows) {
		System.out.println(affectedRows + "개의 제품이 등록되었습니다.");

	}

	// 4. delete
	public void viewDeleteApple(int affectedRows) {
		System.out.println(affectedRows + "개의 제품이 삭제되었습니다.");
	}

}
