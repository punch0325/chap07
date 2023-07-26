package com.exam;

import util.Alpha;
import util.VT100;

public class AlphaMoveExample {
	static class AlphaMove extends Alpha{
		public AlphaMove() {
			line = 1;
			col = 1;		
		}
		
		void right() {
			hide();
			col++;
			show1();
			VT100.reset();
		}
		
		void down() {
			hide();
			line++;
			show1();
			VT100.reset();
		}
		
		void left() {
			hide();
			col--;
			show1();
			VT100.reset();
		}
		
		void up() {
			hide();
			line--;
			show1();
			VT100.reset();
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		AlphaMove aMove = new AlphaMove();
		
		for(;;) {
			
			for (int i = 0; i < 10; i++){
				aMove.right();
				Thread.sleep(100);
			}
			
			for (int i = 0; i < 10; i++){
				aMove.down();
				Thread.sleep(100);
			}
			
			for (int i = 0; i < 10; i++){
				aMove.left();
				Thread.sleep(100);
			}
			
			for (int i = 0; i < 10; i++){
				aMove.up();
				Thread.sleep(100);
			}
		}
		
//		VT100.reset();

	}

}
