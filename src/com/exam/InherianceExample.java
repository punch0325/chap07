package com.exam;

public class InherianceExample {
	static class Parent{
		int line;
		int col;
		
		public Parent(){
			line = 10;
			col = 20;
		}
		
	    void show() {
			System.out.printf("[%d , %d]\n", line, col);
		}
	}
	
	
	static class Child extends Parent{
		                    // Parent의 속성을 물려 받음
	}

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.line);
		System.out.println(child.col);
		child.show();
	}

}
