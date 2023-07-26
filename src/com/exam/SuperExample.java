package com.exam;

public class SuperExample {
	static class A {
		public A() {
			System.out.println("A()...");
		}
	}

	static class B extends A {

		public B() {
			System.out.println("B()...");
//			부모의 생성자가 자식 클래스에 상속이 되지는 않지만 부모의 기본 생성자는 super()에 의해서 무조건 호출이된다. 

		}
	}


	
	static class C {
		public C(int speed) {

		}
	}
	
	
	static class D extends C {
		
		public D(int speed) {
			super(100);
		}



	}
	
	public static void main(String[] args) {
		B b = new B();
	}

}
