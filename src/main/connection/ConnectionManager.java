package main.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionManager {

	private static String url = "jdbc:mysql://localhost:3306/wealthdemo"; // Method 1
	private static String username = "root";
	private static String password = "root";
	private static Connection conn;
	private static PreparedStatement st;

	// private static String[] url1 =
	// {"jdbc:mysql://localhost:3306/wealthdemo","root","root"}; // Method 2

	public static Connection getConnectiond() {

		try {
			conn = DriverManager.getConnection(url, username, password); // Method 1
			// conn = DriverManager.getConnection(url1[0],url1[1],url1[2]); // Method 2
			// (both are obvious array property)
		} catch (Exception exc) {
			System.out.println("Problem");
		}
		return conn;

	

	}

}
