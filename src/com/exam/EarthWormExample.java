package com.exam;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class EarthWormExample {
	
	enum Direction{ RIGHT, LEFT, UP, DOWN	}
	
	static class EarthWorm extends Alpha{
		Direction direction;

		int moveLine = 0;
		int moveCol = 0;
		
		public EarthWorm() {
			line = (int)(Math.random()*30+1);
			col = (int)(Math.random()*30+1);
			moveLine = line;
			moveCol = col;
			direction = Direction.values()[(int)(Math.random()*4)];

		}
		
		void left() {
			hide();
			col--;
			show1();
			if (col == moveCol-5) {
				moveCol = col;
				direction = Direction.values()[(int)(Math.random()*4)];
				do {					
					direction = Direction.values()[(int)(Math.random()*4)];
				} while (direction == Direction.LEFT);
			}
			VT100.reset();
		}
		
		void right() {
			hide();
			col++;
			show1();
			if (col == moveCol+5) {
				moveCol = col;
				direction = Direction.values()[(int)(Math.random()*4)];
				do {					
					direction = Direction.values()[(int)(Math.random()*4)];
				} while (direction == Direction.RIGHT);
			}
			VT100.reset();
		}
		
		void up() {
			hide();
			line--;
			show1();
			if (line == moveLine-5) {
				moveLine = line;
				direction = Direction.values()[(int)(Math.random()*4)];
				do {					
					direction = Direction.values()[(int)(Math.random()*4)];
				} while (direction == Direction.UP);
			}
			VT100.reset();
		}
		
		void down() {
			hide();
			line++;
			show1();
			if (line == moveLine+5) {
				moveLine = line;
				direction = Direction.values()[(int)(Math.random()*4)];
				do {					
					direction = Direction.values()[(int)(Math.random()*4)];
				} while (direction == Direction.DOWN);
			}
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
	
	static class EarthWormTask extends TimerTask{
		EarthWorm alpha = new EarthWorm();
		
		static int count = 0;
		
		public EarthWormTask() {
			EarthWormTask.count++;
		}
		
		@Override
		public void run() {
			if(alpha.getLine()==1 || alpha.getLine()==30 || alpha.getCol()==1 || alpha.getCol()==40) {
				alpha.hide();
				cancel();
				EarthWormTask.count--;
				
				if(EarthWormTask.count == 0) {
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

		for(int i = 0; i < 100; i++) {
			EarthWormTask earthWormTask = new EarthWormTask();
			int speed = (int)(Math.random()*300+10);
			timer.schedule(earthWormTask, 0, speed);
//			Thread.sleep(1000);
		}
		
		VT100.reset();
		
	}

}
