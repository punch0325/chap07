package com.exam;

import java.util.TimerTask;

public class OverridingExample {
	static class A {
		void show() {
			System.out.println("A.show()...");
		}
	}
	
	static class B extends A {
		
		// 부모 클래스의 메소드를 재정의하려고 할 때 메소드의 이름이나 매개변수가 다르면 재정의가 아니라 새로운 메소드를 생성하는 것이다.
		// 따라서 @Override를 재정의하려는 메소드 위에 붙여주면 재정의하는 메소드가 맞는지 검증해준다.
		@Override
		void show() {
			System.out.println("B.show()...");
		}
	}
	
	
	
	public static void main(String[] args) {
		B b = new B();
		b.show();

	}

}
