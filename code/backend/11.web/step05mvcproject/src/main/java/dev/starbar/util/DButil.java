package main.java.dev.starbar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB 서버 접근용 URL
	public static final String DATABASE_NAME = "testdb";
	public static final String USER = "root";
	public static final String PASSWORD = "0408";
	public static final String SELECT_QUERY = "SELECT id, name, size, price FROM coffee";
	
	static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
}
