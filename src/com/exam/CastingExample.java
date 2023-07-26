package com.exam;

public class CastingExample {
	static class A {
		
	}
	static class B extends A{
		
	}
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		A aa = b;
		// 자동 형변환 Up-casting
		
		if (a instanceof B) { //instanceof 연산자 : 객체의 타입을 알아보는 연산자, 강제 형변환 전에 변환이 가능한지 검사하는 기능을 함
			B bb = (B) a; 			
			// 수동 형변환 Down-castiong : B는 자식 클래스이기 때문에 A클래스 타입인 a를 자동 형변환 할 수 없기 때문에 수동 형변환을 한다. 단, instanceof으로 검사하지 않으면 실행 시 에러남
		}
		
		System.out.println("Program End ...");
		

	}

}
