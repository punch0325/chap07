package com.exam;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

//선생님이 풀어준 거
public class AlphaCrossExample3 {
	
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
			VT100.reset();
		}
		
		void right() {
			hide();
			col++;
			show1();
			VT100.reset();
		}
		
		void up() {
			hide();
			line--;
			show1();
			VT100.reset();
		}
		
		void down() {
			hide();
			line++;
			show1();
			VT100.reset();
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
	
	static class CrossTask extends TimerTask{
		Cross alpha = new Cross();
		
		static int count = 0;
		
		public CrossTask() {
			CrossTask.count++;
		}
		
		@Override
		public void run() {
			
			if(alpha.getLine()==1 || alpha.getLine()==20 || alpha.getCol()==1 || alpha.getCol()==40) {
				alpha.hide();
				cancel();
				CrossTask.count--;
				
				if(CrossTask.count == 0) {
					VT100.corsorMove(21, 1);
					VT100.reset();
					System.out.println("Program End ...");
					timer.cancel();
				}
				return;
			}
			
			alpha.move();
			
		}
	}
	
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for (int i = 0; i < 1000; i++) {
			int speed = (int)(Math.random()*300+10);
			timer.schedule(new CrossTask(), 0, speed);
			Thread.sleep(10);
		}
		
		VT100.reset();
		
	}

}
