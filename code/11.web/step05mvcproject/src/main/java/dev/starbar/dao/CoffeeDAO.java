package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dev.starbar.model.Coffee;
import dev.starbar.util.DButil;

/*
 * DAO: Data Access Object
 * DB에 접근할 때 사용되는 코드만 작성하는 부분
 * DriverManager, Statement, ResultSet 등
 * DB 접근과 관련된 코드만 작성!!
 */
public class CoffeeDAO {

	public static List<Coffee> findAll() throws ClassNotFoundException {
		List<Coffee> coffeeList = new ArrayList<>();
		String selectQuery = "SELECT * FROM coffee";
		ResultSet rs = null;
		
		
		try(Connection connection = DButil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			
			rs = statement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String size = rs.getString("size");
				int price = rs.getInt("price");
				
				coffeeList.add(new Coffee(id, name, size, price));
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return coffeeList;
	}

	// coffee 삭제 메소드
	public void deleteCoffee(int delId) throws ClassNotFoundException {
		
		try(Connection connection = DButil.getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM coffee WHERE id = ?");) {

			System.out.println("여기다 여기여 : " + delId);
			
			statement.setInt(1, delId);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// coffee 등록 메소드
	public void insertCoffee(String coffeeName, String coffeeSize, String coffeePrice) throws ClassNotFoundException {
		
		String insertSql = "INSERT INTO coffee (name, size, price) VALUES (?, ?, ?)";
		
		try(Connection connection = DButil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertSql);) {
			
			statement.setString(1, coffeeName);
			statement.setString(2, coffeeSize);
			statement.setString(3, coffeePrice);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// coffee id로 select 조회
	public static Coffee updateOne(String updateId) throws ClassNotFoundException {
		Coffee coffee = null;
		ResultSet rs = null;
		
		try(Connection connection = DButil.getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM coffee WHERE id = ?");) {
			
			statement.setString(1, updateId);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String size = rs.getString("size");
				int price = rs.getInt("price");
				
				coffee = new Coffee(id, name, size, price);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coffee;
	}

	// coffee id로 조회한 기존 coffee 메뉴를 수정
	public void updateCoffee(String coffeeId, String coffeeName, String coffeeSize, String coffeePrice) throws ClassNotFoundException {
		
		try(Connection connection = DButil.getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE coffee SET name = ?, size = ?, price = ? WHERE id = ?");) {
			
			statement.setString(1, coffeeName);
			statement.setString(2, coffeeSize);
			statement.setString(3, coffeePrice);
			statement.setString(4, coffeeId);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
