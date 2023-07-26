package com.exam;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	static class A extends TimerTask{
		@Override
		public void run() {
			System.out.println("oneshot...");
		}
	}
	

	public static void main(String[] args) {
		Timer timer = new Timer();
		
		TimerTask timerTask = new A();
		
//		timer.schedule(timerTask, 5000);
		timer.schedule(timerTask, 0, 1000);
		
		System.out.println("Program End...");
	}

}
