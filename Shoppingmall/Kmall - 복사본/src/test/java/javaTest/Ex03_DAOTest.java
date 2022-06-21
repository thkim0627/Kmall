package javaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import util_DB.MemberDAO;
import vo.MemberVO;

// *** DAO Test 시나리오

// Test1) Detail 이 정확하게 구현되어있는지 확인
// => 존재하는 id Test -> notNull : green
// => 존재하지않는 id Test -> Null : red

// Test2) Insert 의 정확성 Test
// => 입력가능 데이터 적용시 성공 , 1 return : green
// => 입력불가능 데이터 적용시 실패 , 0 return : red

public class Ex03_DAOTest {
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = new MemberVO();
	
	// Test1) Detail 의 정확성
	public void detailTest() {
		// 1.1) 존재하는 id
		//vo.setId("banana");
		
		// 1.2) 존재하지 않는 id
		vo.setId("lunch000");
		assertNotNull(dao.memberDetail(vo)); 
	} //detailTest 
	
	@Test
	public void insertTest() {
		vo.setId("junit");
		vo.setPassword("12345");
		vo.setName("유니트");
		vo.setLev("C");
		vo.setBirthd("1999-09-09");
		vo.setPoint(1000);
		vo.setWeight(123.45);
		
		assertEquals(dao.insert(vo), 1) ;        
		// => 성공:1 , 실패:0
		
	} // insertTest

} //class
