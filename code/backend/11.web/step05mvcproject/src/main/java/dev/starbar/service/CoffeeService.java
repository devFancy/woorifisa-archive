package dev.starbar.service;

import java.util.List;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

/*
 * 해당 프로그램의 핵심 로직을 담고 있는 부분
 * 다른 외부 코드들과 최대한 분리
 * DB에 접근하는 DAO를 호출해서 사용
 */
public class CoffeeService { //Service - 비즈니스 로직 작성 부
	List<Coffee> coffees;
	Coffee coffee;
	
	private CoffeeDAO coffeeDAO;

	public CoffeeService() {
		this.coffeeDAO = new CoffeeDAO();
	}
	
	// 전체 조회 - CoffeeDAO.findAll()
	public List<Coffee> findAll() {
		// DB에서 전체 Coffee 데이터 조회를 위해 DAO의 findAll() 호출
		try {
			coffees = CoffeeDAO.findAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 결과 데이터를 CoffeeListController에게 반환
		return coffees;
	}

	// 삭제 - coffeeDAO.deleteCoffee()
	public void deleteCoffee(String delId) {
		
		// DB에서 삭제할 Coffee id를 받아서 삭제하는 deleteCoffee() 호출
		try {
			int parsedDelId = Integer.parseInt(delId);
			coffeeDAO.deleteCoffee(parsedDelId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 생성 - coffeeDAO.insertCoffee()
	public void insertCoffee(String coffeeName, String coffeeSize, String coffeePrice) {
		try {
			coffeeDAO.insertCoffee(coffeeName, coffeeSize, coffeePrice);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 업데이트 할 특정 커피 번호로 조회(GET) - CoffeeDAO.updateOne()
	public Coffee findOne(String updateId) {
		try {
			coffee = CoffeeDAO.updateOne(updateId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 결과 데이터를 CoffeeListController에게 반환
		return coffee;
	}

	// 업데이트 고고(POST) - coffeeDAO.updateCoffee()
	public void updateCoffee(String coffeeId , String coffeeName, String coffeeSize, String coffeePrice) {
		try {
			coffeeDAO.updateCoffee(coffeeId, coffeeName, coffeeSize, coffeePrice);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
