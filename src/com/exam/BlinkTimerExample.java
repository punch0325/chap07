package com.exam;

import java.util.Timer;
import java.util.TimerTask;

import util.VT100;

public class BlinkTimerExample {
	static class Blink extends TimerTask{
		static int count;
		int num;
		
		public Blink() {
			num = count;
			count++;
		}
		
		@Override
		public void run() {
			System.out.println(num+"...");
		}
	}

	public static void main(String[] args) {
		VT100.clearScreen();
		
		Timer timer = new Timer();
		
		for(int i = 0; i <2; i++) {
			Blink blink = new Blink();
			int speed = (int)(Math.random()*500+20);
			timer.schedule(blink, 0, speed);
		}
		
		VT100.reset();
	}

}
