package applTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import util_DB.MemberDAO;
import vo.MemberVO;

public class ConDAOTest {
	
	// ** 조건 3.1  DBConnection Test
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			System.out.println("** JDBC Connection 요기까지 성공 **");
			return DriverManager.getConnection(url, "root", "mysql000") ;  
														// password 오류 유도
		} catch (Exception e) {
			System.out.println("** JDBC Connection 실패 => "+e);
			return null;
		} //try
	} //getConnection
	 
	public void connectionTest() {
		System.out.println("*** Connection => "+getConnection());
		// true: notNull 연결성공 , false: null 연결실패
		assertNotNull(getConnection());    
	} //connectionTest
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = new MemberVO();
	@Test
	// ** 조건 3.2  DAO Test1
	// => 존재하면 notNull , 존재하지 않으면 Null
	public void testDetail1() throws Exception {
		// 존재 ID 요청 
		//vo.setId("banana");
		// 존재하지않는 ID 요청 
		vo.setId("noname");
		
		// Test
		assertNotNull(dao.memberDetail(vo));
	} // testDetail1`	`
	
	
	// ** 조건 3.3  DAO Test2
	public void testDetail2() throws Exception {
		// 요청 ID
		String id = "banana";
		vo.setId("banana");
		vo = dao.memberDetail(vo);
		if (vo != null) {
			System.out.println("***** memberDetail 성공, id => "+vo.getId());
			assertEquals(vo.getId(), id);
		} else {
			System.out.println("***** memberDetail 실패, id => "+vo.getId());
		} // else
	} // testDetail2

} //class
