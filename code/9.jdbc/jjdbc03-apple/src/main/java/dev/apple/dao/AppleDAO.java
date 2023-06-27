package dev.apple.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.apple.model.Apple;
import dev.apple.util.DBUtil;

public class AppleDAO {

	// JDK 1.7버전 이전 방식
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	int affectedRows;

	
	
	// 1. findAllApple : 전체 상품 조회
	public List<Apple> findAllApple() {

		List<Apple> apples = new ArrayList<>();

		// query문
		final String findAllQuery = "SELECT * FROM apple_store";

		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();

			resultSet = statement.executeQuery(findAllQuery);

			while (resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				String category = resultSet.getString("category");
				int price = resultSet.getInt("price");
				String color = resultSet.getString("color");
				Date date = resultSet.getDate("release_date");
				LocalDate releaseDate = date.toLocalDate();

				apples.add(new Apple(productId, category, price, color, releaseDate));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return apples;
	}

	
	
	// 2. buyApple : 상품 구매
	public Apple buyApple(int insertBuyId) {

		// query문
		final String findBuyQuery = "SELECT * FROM apple_store WHERE product_id = ?";
		Apple apple = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(findBuyQuery);) {

			statement.setInt(1, insertBuyId); // ? 에 맵핑(바인딩)할 값을 지정, 좌측부터 물음표 개수만큼 넘버링
			resultSet = statement.executeQuery();

			resultSet.next();
			int productId = resultSet.getInt("product_id");
			String category = resultSet.getString("category");
			int price = resultSet.getInt("price");
			String color = resultSet.getString("color");
			Date date = resultSet.getDate("release_date");
			LocalDate releaseDate = date.toLocalDate();

			apple = new Apple(productId, category, price, color, releaseDate);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {

			}
		}

		return apple;
	}
	
	
	
	// 3. updateApple : 상품 업데이트
	public int updateApple(String insertCategory, int insertPrice, String insertColor, String insertReleaseDate) {

		// query문
		final String insertQuery = "INSERT INTO apple_store (category, price, color, release_date) VALUES (?, ?, ?, ?)";

		try (
				Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {

			statement.setString(1, insertCategory);
			statement.setInt(2, insertPrice);
			statement.setString(3, insertColor);
			statement.setString(4, insertReleaseDate);

			affectedRows = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	
	// 4. deleteApple : 상품 삭제
	public int deleteApple(int deleteId) {

		// query문
		final String deleteQuery = "DELETE FROM apple_store WHERE product_id = ?";

		try (
				Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteQuery);) {
			
			statement.setInt(1, deleteId);
			affectedRows = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

}
