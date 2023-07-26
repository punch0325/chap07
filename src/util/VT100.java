package util;

public interface VT100 {
	
	public static void clearScreen() {
		System.out.println("\033[2J");
	}
	
	public static void corsorMove(int line, int col) {
		System.out.printf("\033[%d;%dH", line , col);
	}
	
	public static void setForeground(int fg) {
		System.out.printf("\033[%dm", fg);
	}
	
	public static void setForeground(Color fg) {
		System.out.printf("\033[%dm", fg.ordinal()+30);
	}	
	
	public static void setbackground(int bg) {
		System.out.printf("\033[%dm", bg);
	}

	public static void setbackground(Color bg) {
		System.out.printf("\033[%dm", bg.ordinal()+40);
	}
	
	public static void reset() {
		System.out.println("\033[0m");
	}
	
	public static void printChar(char ch) {
		System.out.println(ch);
	}
	
	public static int forCount(int forCount) {
		forCount++;
		
		return forCount;
	}
	
	
}
