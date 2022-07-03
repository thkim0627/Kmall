package util_DB;

import java.sql.Connection;
import java.sql.DriverManager;

// Database 연결
// Connection 클래스가 Database 연결 및 연결정보를 관리한다.
// 즉, Connection 객체를 생성해야한다.
public class DBConnection {

	// Connection 객체 생성 
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			System.out.println("> JDBC Connection 성공 <");
			return DriverManager.getConnection(url, "root", "mysql") ;
		} catch (Exception e) {
			System.out.println("> JDBC Connection 실패 : " + e);
			return null;
		} //try
	} //getConnection
	
} //class