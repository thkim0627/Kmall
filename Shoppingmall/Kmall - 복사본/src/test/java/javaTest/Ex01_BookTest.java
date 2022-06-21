package javaTest;

import static org.junit.Assert.*;

import org.junit.Test;

// ** Book class
//=> 접근범위 default, 맴버필드 3개 정의, 맴버필드 3개를 초기화하는 생성자를 만드세요 ~
class Book {
	String title;
	String author;
	int price;
	
	Book(String title, String author, int price) {
		this.title=title;
		this.author=author;
		this.price=price;
	}
	
	public boolean isBook(boolean b) {
		return b;
	}
	
} //Book

// *** JUnit 실행
// => 스프링의 경우 dependency 만 추가하면 됨.
// => 단, 추가후 에도 version에 따라 연결되지 않는 경우에는
//    project 우클릭 - Build Path - Configure Build Path 
//    				- Libraries 탭 , Add Library.. 
//				    – JUnit, Junit version -> 4 or 5 선택
//                  ( 단, Spring Test 시에는 4 가 적절 , 5 선택시 실행안됨 )    

//** @ 종류
//=> @Before - @Test - @After
//=> @ 적용 메서드 : non static, void 로 정의 해야 함.

//** org.junit.Assert 가 지원하는 다양한 Test용 Method 
// => true (green_Line) 또는 false (red_Line) return 
//1) assertEquals(a,b) : a와 b의 값(Value) 이 같은지 확인
//2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
//3) assertTrue(a) : a가 참인지 확인
//4) assertNotNull(a) : a객체가 Null 이 아님을 확인
//5) assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인

public class Ex01_BookTest {
	
	//1) assertEquals(a,b)  
	public void equalsTest() {
		Book b1 = new  Book("죄 와 벌","톨스토이", 9900);
		Book b2 = new  Book("죄 와 벌","홍길동", 9900);
		//assertEquals(b1.author, b2.author); // red Test
		assertEquals(b1.author, "톨스토이");     // green Test
	} //equalsTest 
	
	//2) assertSame(a,b) 
	// => a, b 인스턴스 이면 주소비교 : 객체동질성 
	// => a, b 기본자료형이면 값(value) 비교
	public void sameTest() {
		Book b1 = new  Book("죄 와 벌","톨스토이", 9900);
		Book b2 = new  Book("죄 와 벌","톨스토이", 9900);
		//assertSame(b1, b2); // 주소비교 : red Test 
		//assertSame(b1.author, b2.author); // 값(value) 비교 : green
		b1 = b2 ;
		assertSame(b1, b2); // green
	} //sameTest 
	
	@Test
	//3) assertTrue(a)
	public void trueTest() {
		Book b1 = new  Book("죄 와 벌","톨스토이", 9900);
		assertTrue(b1.isBook(false)); // red
		//assertTrue(b1.isBook(true));  // green
	} //trueTest
	
	//4) assertNotNull(a)
	public void notNullTest() {
		Book b1 = new  Book("죄 와 벌","톨스토이", 9900);
		Book b2 = null ;
		System.out.println("** b1 => "+b1);
		//assertNotNull(b1); // green
		assertNotNull(b2);  // red
	} //notNullTest
	
	//5) assertArrayEquals(a,b)
	public void arrayEqualsTest() {
		String[] a1 = {"가","나","다"}; 
		String[] a2 = {"가","나","다"};
		String[] a3 = {"가","다","나"};
		String[] a4 = {"가","바","파"};
		// 5.1) 두배열의 순서, 값 모두 동일 (a1, a2)
		//assertArrayEquals(a1, a2);  // true -> green
		// 5.2) 두배열의 순서는 다르고, 값 모두 동일 (a1, a3)
		//assertArrayEquals(a1, a3);  // false -> red
		// 5.3) 모두 다른경우 (a1, a4)
		assertArrayEquals(a1, a3);    // false -> red
	} //arrayEqualsTest
	
} //class Ex01_BookTest
