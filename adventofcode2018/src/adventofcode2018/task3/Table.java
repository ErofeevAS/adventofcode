package adventofcode2018.task3;

public class Table {
	private int id;
	private int x0;
	private int y0;
	private int x;
	private int y;

	public Table(int id, int x0, int y0, int x, int y) {
		super();
		this.id = id;
		this.x0 = x0;
		this.y0 = y0;
		this.x = x;
		this.y = y;
	}

	public Table(int x0, int y0, int x, int y) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
