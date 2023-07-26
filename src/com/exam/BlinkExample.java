package com.exam;

import util.Alpha;
import util.VT100;

public class BlinkExample {
	static class Blink extends Alpha {
		int speed;
		
		public Blink() {
			this(100);  //speed 필드의 값
		}
		
		public Blink(int speed) {
//			super();    ▶ 생성자를 호출함. 생략해도 기본적으로 생성 되어 있는 것임
			this.speed = speed;
		}
		
			
		void blink() throws InterruptedException {
			show1();
			Thread.sleep(speed);
			hide();
			Thread.sleep(speed);
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		Blink blink = new Blink();
		for(int i =0; i<=10; i++)
			blink.blink();
		
		blink.show1();
		blink.hide();


		
		System.out.println("Program End..");
	}

}
