package com.exam;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class BlinkTimerExample2 {
	static class Blink extends TimerTask{
		Alpha alpha = new Alpha();
		
		boolean isShow = false;
		
		@Override
		public void run() {
			if (!isShow) 
				alpha.show1();
			else
				alpha.hide();
			
			isShow = !isShow;
			
		}
	}

	
	public static void main(String[] args) {
		VT100.clearScreen();
		
		Timer timer = new Timer();
		
		for(int i = 0; i <10; i++) {
			Blink blink = new Blink();
			int speed = (int)(Math.random()*500+20);
			timer.schedule(blink, 0, speed);
		}
		
		VT100.reset();
	}

}
