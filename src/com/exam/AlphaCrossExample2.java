package com.exam;

import util.Alpha;
import util.VT100;

//선생님이 풀어준 거
public class AlphaCrossExample2 {
	
	enum Direction{
		UP, DOWN, LEFT, RIGHT
	}
	
	static class Cross extends Alpha{
		final Direction direction; 
		
		public Cross() {
			line = 10;
			col = 20;
			direction = Direction.values()[(int)(Math.random()*4)];
		}
		
		void left() {
			hide();
			col--;
			show1();
		}
		
		void right() {
			hide();
			col++;
			show1();
		}
		
		void up() {
			hide();
			line--;
			show1();
		}
		
		void down() {
			hide();
			line++;
			show1();
		}
		
		void move() {
			switch (direction) {
			case UP:
				up();
				break;
			case DOWN:
				down();
				break;
			case LEFT:
				left();
				break;
			case RIGHT:
				right();
				break;
			default:
				break;
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		Cross cross = new Cross();
		
		for (;;) {			
			cross.move();
			
			if(cross.getLine()==1 || cross.getCol()==1 || cross.getLine()==20 || cross.getCol()==40) {
				cross.hide();
				break;
			}
			
			Thread.sleep(100);
		}
		
		VT100.reset();
		
	}

}
