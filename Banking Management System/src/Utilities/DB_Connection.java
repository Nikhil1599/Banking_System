package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	public static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_management_system","root","Nikhil15@");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
