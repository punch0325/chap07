package com.exam;

public class SealedClassExample {
	static sealed class Person permits Employee, Manager{
		    // 원래는 자식 클래스가 부모 클래스를 선택하지만 반대로 부모 클래스가 자식 클래스를 선택하는 것
	}
	
	static non-sealed class Employee extends Person{
					// 부모에게 자식으로 선택 받은 클래스는 non-sealed를 붙여주어야 한다.
	}
	
	static non-sealed class Manager extends Person{
		
	}
	
	static class Student /*extends Person*/{
		      //부모에게 자식 클래스로 선택 받지 못하였으므로 해당 부모 클래스를 가질 수 없다.
		
	}
	
	
	
	public static void main(String[] args) {

	}

}
