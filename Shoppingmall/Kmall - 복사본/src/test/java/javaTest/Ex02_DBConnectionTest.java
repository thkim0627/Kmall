package javaTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class Ex02_DBConnectionTest {

	// ** Connection 객체 생성 Test 
	// => Test@ 적용 메서드 : non static, void 로 정의 해야 함.
	// => static, return 값이 있는 메서드를 Test하는 경우
	//    1) Test 메서드를 작성해서 Test
	// 	  2) non static, void 로 재정의 후 Test	
	
	// 1) Test 메서드를 작성해서 Test
	// => id, password 오류 : Access denied for user 'root'@'localhost' (using password: YES)
	// => portNo 오류 : java.sql.SQLNonTransientConnectionException: 
	//					Could not create connection to database server.
	// => 드라이버 이름 : java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver111
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			System.out.println("** JDBC Connection 요기까지 성공 **");
			return DriverManager.getConnection(url, "root", "mysql") ;
		} catch (Exception e) {
			System.out.println("** JDBC Connection 실패 => "+e);
			return null;
		} //try
	} //getConnection
	
	public void connectionTest() {
		System.out.println("*** Connection => "+getConnection());
		// true: notNull 연결성공 , false: null 연결실패
		assertNotNull(getConnection());  // 
	} //connectionTest
	
	@Test
	// 2) non static, void 로 재정의 후 Test
	public void getConnectionVoid() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url, "root", "mysql") ;
			System.out.println("** JDBC Connection 성공 => "+cn);
		} catch (Exception e) {
			System.out.println("** JDBC Connection 실패 => "+e);
		} finally {
			assertNotNull(cn);
			// true: notNull 연결성공 , false: null 연결실패
			// => 위 메서드 있는것과 없는경우의 차이점 비교
			//   ( 없을떄는 Connection 실패시에도 항상 green ) 
		}    
	} //getConnectionVoid 
	
} //class
