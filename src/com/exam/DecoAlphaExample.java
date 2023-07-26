package com.exam;

import util.Alpha;
import util.VT100;

public class DecoAlphaExample {
	static class DecoAlpha extends Alpha{
		@Override
		public void show1(){
			super.show1(); 
//			부모가 정의 해놓은 메소드를 불러옴
			
			VT100.reset();
			VT100.corsorMove(getLine()+1, getCol());
			VT100.printChar('=');
//			실행문을 추가하여 부모가 정의 해놓은 메소드를 부분만 바꾸어 오버라이딩
		}
		
		@Override
		public void hide() {
			super.hide();
			
			VT100.reset();
			VT100.corsorMove(getLine()+1, getCol());
			VT100.printChar('_');
		}
		
		private void bilnk() throws InterruptedException {
			show1();
			Thread.sleep(100);
			hide();
			Thread.sleep(100);
		}

	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		DecoAlpha  dAlpha = new DecoAlpha();
		for(int i =0; i<=10; i++)
			dAlpha.bilnk();
		
		dAlpha.show1();
		dAlpha.hide();
		
		VT100.reset();

	}

}
