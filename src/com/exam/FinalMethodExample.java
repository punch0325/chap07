package com.exam;

public class FinalMethodExample {
	static class A{
		final void xxx() {
			// 부모 클래스에 있는 메소드가 final 메소드이면 자식 클래스에서 오버라이딩 할 수 없음
		}
		void yyy() {
			
		}
	}
	
	static class B extends A{
//		@Override
//		void xxx() {
//			
//		}
		@Override
		void yyy() {
		
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
