package adventofcode2018.task6;

public class Coordinates {
	private int X;
	private int Y;
	private String ch;

	public Coordinates() {
		super();

	}

	public Coordinates(int x, int y, String ch) {
		super();
		X = x;
		Y = y;
		this.ch = ch;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

}
