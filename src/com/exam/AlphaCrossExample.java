package com.exam;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

//내가 푼거
public class AlphaCrossExample {
	static class AlphaMove extends Alpha{
		public AlphaMove() {
			line = 25;
			col = 25;		
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
	
	enum Direction { UP, DOWN, LEFT, RIGHT }
	
	static class MoveTimerTask extends TimerTask{
		static int totalCount = 0;
		
		AlphaMove alphaMove = new AlphaMove();
		
		
		int count;
		Direction direction = Direction.values()[(int)(Math.random()*4)];
		
		public MoveTimerTask() {
		
			totalCount++;
		}
		
		@Override
		public void run() {			
				switch (direction) {
				case RIGHT:
					alphaMove.right();
					break;
				case DOWN:
					alphaMove.down();
					break;
				case LEFT:
					alphaMove.left();
					break;
				case UP:
					alphaMove.up();
					break;
				default:
					break;
				}
				
				
				if(alphaMove.getLine() == 25 && alphaMove.getCol() == 50) {					
					count++;
				}
				else if(alphaMove.getLine() == 50 && alphaMove.getCol() == 25)
					count++;
				else if(alphaMove.getLine() == 25 && alphaMove.getCol() == 1)
					count++;
				else if(alphaMove.getLine() == 1 && alphaMove.getCol() == 25)
					count++;
			
			
			
			
			if(count == 1) {
				alphaMove.hide();
				cancel();
				count--;
				totalCount--;
				if(totalCount==0) {
					VT100.reset();
					VT100.corsorMove(21, 1);
					System.out.println("Program End ...");
					timer.cancel();
				}	
			}
			
			
		}
	}
	
	static Timer timer = new Timer();
	
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for(int i = 0; i<300; i++) {
			
			MoveTimerTask t = new MoveTimerTask();
			int speed = (int)(Math.random()*300+10);
			timer.schedule(t, 0, speed);
			Thread.sleep(50);
			
		}

		VT100.reset();

	}

}
