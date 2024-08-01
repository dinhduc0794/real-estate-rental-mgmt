package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static String USER = "root";
	private static String PASS = "2210794";
	
	public static final Connection GetConnection() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
