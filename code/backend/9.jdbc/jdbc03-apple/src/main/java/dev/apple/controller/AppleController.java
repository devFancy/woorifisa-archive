package dev.apple.controller;

import java.util.List;

import dev.apple.dao.AppleDAO;
import dev.apple.model.Apple;
import dev.apple.view.AppleView;

public class AppleController {

	private final AppleDAO appleDao;
	private final AppleView viewer;

	int affectedRows;

	public AppleController() {
		appleDao = new AppleDAO();
		viewer = new AppleView();
	}

	// 1. findAllApple : 전체 상품 조회
	public void findAllApple() {
		List<Apple> apples = appleDao.findAllApple();
		
		if(apples != null && apples.size() != 0) {
			viewer.viewFindAllApple(apples);
		}else {
			System.out.println("와 오류다");
		}
		
	}

	// 2. buyApple : 상품 구매
	public void buyApple(int insertBuyId) {
		Apple apple = appleDao.buyApple(insertBuyId);
		viewer.viewBuyApple(apple);
	}

	// 3. updateApple : 상품 업데이트
	public void updateApple(String insertCategory, int insertPrice, String insertColor, String insertReleaseDate) {
		affectedRows = appleDao.updateApple(insertCategory, insertPrice, insertColor, insertReleaseDate);
		viewer.viewUpdateApple(affectedRows);
	}

	// 4. deleteApple : 상품 삭제
	public void deleteApple(int deleteId) {
		affectedRows = appleDao.deleteApple(deleteId);
		viewer.viewDeleteApple(affectedRows);
	}

}
