package applTest;

import static org.junit.Assert.*;

import org.junit.Test;

// ** 1. Car 클래스 
class Car {
	String name;
	String color;
	int price;

	Car(String name, String color, int price) {
		this.name = name;
		this.color = color;
		this.price = price;
	} // 생성자
} // class


public class CarTest {
 
	// assertEquals(a,b) : a와 b의 값이 같은지 확인
	public void equalsTest() {
		Car c1 = new Car("자동차1", "White", 10000);
		Car c2 = new Car("자동차2", "Black", 10000);
		assertEquals(c1.color, c2.color);
		// True: 성공(그린라인), False: 실패 (레드라인,오류) 로 처리
	}
	
	// assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
	public void sameTest() {
		Car c1 = new Car("자동차", "Black", 10000);
		Car c2 = new Car("자동차", "Black", 10000);
		Car c3 = c1;
		//assertSame(c1, c3);  // true
		assertSame(c1, c2);  // false
	}
	
	@Test
	// assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
	public void arrayEqualsTest() {
		Car[] arrc1 = { new Car("자동차", "Black", 10000), new Car("자동차", "White", 10000) };
		Car[] arrc2 = { new Car("자동차", "Black", 10000), new Car("자동차", "White", 10000) };
		assertArrayEquals(arrc1, arrc2);
		// 참조형 데이터의 배열은 동질성 True 안나옴.
	}

} // CarTest
