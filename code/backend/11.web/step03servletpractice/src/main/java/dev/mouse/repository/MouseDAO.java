package dev.mouse.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.mouse.domain.Mouse;
import dev.mouse.util.DBUtil;

public class MouseDAO {

	public static List<Mouse> findAll() throws ClassNotFoundException {
		List<Mouse> mice = new ArrayList<>();
		String selectQuery = "SELECT * FROM mouse";
		ResultSet rs = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {

			rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String country = rs.getString("country");
				String address = rs.getString("address");

				mice.add(new Mouse(id, name, country, address));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mice;
	}

	public void add(Mouse newMouse) {
		
		String selectQuery = "INSERT INTO mouse (name, country, address) VALUES (?, ?, ?)";
		ResultSet rs = null;

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {

			statement.setString(1, newMouse.getName());
			statement.setString(2, newMouse.getCountry());
			statement.setString(3, newMouse.getAddress());
			
			statement.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
