package util;

public class Alpha {
	
	protected int line;
	protected int col;
	protected Color fg;
	protected Color bg;
	protected char ch;
	protected	int forCount;
	
//	■Getter , Setter
//	Java는 필드에 직접적으로 접근하는 것 보다 보호하는 것을 권장하기 때문에 
//	게터와 세터 메소드를 이용하여 간접적으로 필드에 접근해서 데이터를 읽고 쓴다.
	public int getLine() {
		return line;
	}
	public int getCol() {
		return col;
	}
	public Color getFg() {
		return fg;
	}
	public Color getBg() {
		return bg;
	}
	public char getCh() {
		return ch;
	}
	public int getforCount() {
		return forCount;
	}
	
	
	public void setLine(int line) {
		this.line = line;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public void setFg(Color fg) {
		this.fg = fg;
	}
	public void setBg(Color bg) {
		this.bg = bg;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public void setforCount(int col) {
		this.forCount = forCount;
	}

	
	
	public Alpha() {
		line = (int)(Math.random()*20+1);
		col = (int)(Math.random()*40+1);
		
		do {			
			fg = Color.values()[(int)(Math.random()*8)];
			bg = Color.values()[(int)(Math.random()*8)];
		}while(fg==bg);
		// fg 랑 bg가 같으면 다시 랜덤으로 데이터를 대입하라는 뜻
		
		ch = (char)(Math.random()*26 + 'A');
		
		forCount++;
		
	}
	
	public void show1() {
		VT100.corsorMove(line, col);
		VT100.setForeground(fg);
		VT100.setbackground(bg);
		VT100.printChar(ch);
	}
	
	public void hide() {
		VT100.corsorMove(line, col);
		VT100.printChar(' ');
		VT100.reset();
	}
		

}
