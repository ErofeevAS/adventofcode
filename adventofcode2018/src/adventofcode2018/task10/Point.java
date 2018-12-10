package adventofcode2018.task10;

public class Point {
	private int X;
	private int Y;
	private int speedX;
	private int speedY;

	public Point(int x, int y, int speedX, int speedY) {
		super();
		X = x;
		Y = y;
		this.speedX = speedX;
		this.speedY = speedY;
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

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
