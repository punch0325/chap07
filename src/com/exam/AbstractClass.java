package com.exam;


public class AbstractClass {
	// abstract : 추상 클래스 , new 연산자를 사용할 수 없음
	static abstract class Animal{
		abstract void sound();
		// 추상 클래스는 추상 메소드를 가질 수 있는데, {}가 없이 앞에 abstract를 붙인다
	}
	
	static class Cat extends Animal{

		@Override
		void sound() {
//		 일반 부모 클래스의 메소드는 꼭 오버라이딩을 할 필요가 없지만,
//		 추상클래스의 추상메소드는 불완전한(미완성)이기 때문에 반드시 자식 클래스에서 오버라이딩을 강제한다.
			System.out.println("야옹");
		}
		
	}
	
	static class Dog extends Animal{

		@Override
		void sound() {
			System.out.println("멍멍");	
		}
		
	}

	static class People extends Animal{

		@Override
		void sound() {
			System.out.println("야호");
		}
	
	}
	
	
	
	
	public static void main(String[] args) {
		Animal animal1 = new Cat();
		Animal animal2 = new Dog();
		Animal animal3 = new People();
		
		animal1.sound();
		animal2.sound();
		animal3.sound();

	}

}
