package javaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import util_DB.MemberDAO;
import vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Ex04_SpringDAO {
	
	// ** 자동주입 : 생성은 root~~~.xml 로 설정
	// => 해당 클래스 들은 생성 되어있어야함.
	@Autowired
	MemberDAO dao;
	@Autowired
	MemberVO vo;
	
	// Test1) Detail 의 정확성
	public void detailTest() {
		// 1.1) 존재하는 id
		vo.setId("banana");
		
		// 1.2) 존재하지 않는 id
		//vo.setId("lunch000");
		assertNotNull(dao.memberDetail(vo)); 
	} //detailTest 
	
	@Test
	public void insertTest() {
		vo.setId("jspring");
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
