package adventofcode2018.task13;

public class Cart implements Comparable<Cart> {

	private String name;
	private int x;
	private int y;
	private Direction direction;
	private int countCrossRoad = 0;

	public Cart(String name, int x, int y, Direction direction) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Cart() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void crossRoad() {
		countCrossRoad = countCrossRoad % 3;

		if (countCrossRoad == 0) {
			if (getDirection().equals(Direction.TOP)) {
				direction = Direction.LEFT;
			} else if (getDirection().equals(Direction.BOTTOM)) {
				direction = Direction.RIGHT;
			} else if (getDirection().equals(Direction.LEFT)) {
				direction = Direction.BOTTOM;
			} else if (getDirection().equals(Direction.RIGHT)) {
				direction = Direction.TOP;
			}
			countCrossRoad++;
			
		} else if (countCrossRoad == 1) {
			countCrossRoad++;
			
		} else if (countCrossRoad == 2) {
			if (getDirection().equals(Direction.TOP)) {
				direction = Direction.RIGHT;
			} else if (getDirection().equals(Direction.BOTTOM)) {
				direction = Direction.LEFT;
			} else if (getDirection().equals(Direction.LEFT)) {
				direction = Direction.TOP;
			} else if (getDirection().equals(Direction.RIGHT)) {
				direction = Direction.BOTTOM;
			}
			countCrossRoad++;
		}

	}

	@Override
	public String toString() {
		return "Cart [name=" + name + ", x=" + x + ", y=" + y + ", direction=" + direction + ", countCrossRoad="
				+ countCrossRoad + "]";
	}

	@Override
	public int compareTo(Cart o) {
		int y1 = this.getY();
		int x1 = this.getX();
		int y2 = o.getY();
		int x2 = o.getX();

		if (y1 < y2) {
			return -1;
		}
		if (y1 > 2) {
			return 1;
		}
		if (y1 == y2) {
			if (x1 < x2) {
				return -1;
			} else if (x1 > x2) {
				return 1;
			} else {
				return 0;
			}
		}

		return 0;
	}

}
