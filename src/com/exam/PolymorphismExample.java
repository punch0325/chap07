package com.exam;

public class PolymorphismExample {

	static  class Shape{
		void draw() {
			System.out.println("뭘 하지 ?");
		}
	}
	
	static class Rectangle extends Shape{
		@Override
		void draw() {
			System.out.println("####");
			System.out.println("####");
			System.out.println("####");
			System.out.println("####");
		}
	}
	
	static class Triangle extends Shape{
		@Override
		void draw() {
			System.out.println("#");
			System.out.println("##");
			System.out.println("###");
			System.out.println("####");
		}
		
	}
	
	public static void main(String[] args) {
		//다형성 : 사용 방법은 똑같지만 여러 실행 결과가 나오는 것
		Shape s = new Shape();
		s.draw();
		
		s = new Rectangle();
		s.draw();
		
		s = new Triangle();
		s.draw();
		
	}

}
