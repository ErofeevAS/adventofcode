package adventofcode2018.task13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import adventofcode2018.FileReader;

public class Task13 {

	int step = 0;
	private char[][] mine;
	private List<Cart> carts = new ArrayList<Cart>();
	private List<Cart> crashedCarts = new ArrayList<Cart>();
	DrawingPanel panel;
	JFrame frame = new JFrame("cart crash");
	int maxX;
	int maxY;

	private void init(String fileName) throws IOException {
		String[] data = FileReader.readFromFile(fileName);
		maxX = data[0].length();
		maxY = data.length;
		mine = new char[maxY][maxX];
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				mine[y][x] = data[y].charAt(x);
			}
		}
		panel = new DrawingPanel(mine);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(6 * maxX + 100, 6 * maxY + 100);
		frame.setVisible(true);

	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	private List<Cart> getAllCarts() {
		String name = "";
		int cnt = 0;
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				Cart cart = null;
				if (mine[y][x] == '>') {
					mine[y][x] = '-';
					cart = new Cart(name + cnt, x, y, Direction.RIGHT);
					cnt++;
				}
				if (mine[y][x] == '<') {
					mine[y][x] = '-';
					cart = new Cart(name + cnt, x, y, Direction.LEFT);
				}
				if (mine[y][x] == '^') {
					mine[y][x] = '|';
					cart = new Cart(name + cnt, x, y, Direction.TOP);
				}
				if (mine[y][x] == 'v') {
					mine[y][x] = '|';
					cart = new Cart(name + cnt, x, y, Direction.BOTTOM);
				}
				if (cart != null) {
					carts.add(cart);
				}
			}
		}
		return carts;
	}

	private List<Cart> sortCarts() {
		Collections.sort(carts);
		return carts;
	}

	private void getNextCrossRoadDirection(char ch, Cart cart) {
		switch (ch) {
		case '-': {
			break;
		}
		case '|': {
			break;
		}
		case '/': {
			if (cart.getDirection().equals(Direction.TOP)) {
				cart.setDirection(Direction.RIGHT);
			} else if (cart.getDirection().equals(Direction.BOTTOM)) {
				cart.setDirection(Direction.LEFT);
			} else if (cart.getDirection().equals(Direction.LEFT)) {
				cart.setDirection(Direction.BOTTOM);
			} else if (cart.getDirection().equals(Direction.RIGHT)) {
				cart.setDirection(Direction.TOP);
			}
			break;
		}
		case '\\': {
			if (cart.getDirection().equals(Direction.RIGHT)) {
				cart.setDirection(Direction.BOTTOM);
			} else if (cart.getDirection().equals(Direction.LEFT)) {
				cart.setDirection(Direction.TOP);
			} else if (cart.getDirection().equals(Direction.TOP)) {
				cart.setDirection(Direction.LEFT);
			} else if (cart.getDirection().equals(Direction.BOTTOM)) {
				cart.setDirection(Direction.RIGHT);
			}
			break;
		}
		case '+': {
			cart.crossRoad();
			break;
		}
		default:
			break;
		}
	}

	private String checkCrash() {
		String crashCoord = "";
		for (int i = 0; i < carts.size(); i++) {
			int x1 = carts.get(i).getX();
			int y1 = carts.get(i).getY();
			for (int j = 0; j < carts.size(); j++) {
				int x2 = carts.get(j).getX();
				int y2 = carts.get(j).getY();
				if (i != j) {
					if ((x1 == x2) && (y1 == y2)) {
						crashCoord = "" + x2 + ',' + y2;
						removeCrashedCarts(x1, y1);
						return crashCoord;
					}
				}
			}
		}
		return null;
	}

	private void makeOneStep() {
		step++;
		String result = "";
		List<Cart> sortedcarts = this.sortCarts();
		List<Cart> sortedCartsCopy = new ArrayList<Cart>(sortedcarts);
		for (Cart cart : sortedCartsCopy) {
			Direction currDirection = cart.getDirection();
			char nextMove;
			int x = cart.getX();
			int y = cart.getY();

			switch (currDirection) {
			case TOP: {
				nextMove = mine[y - 1][x];
				cart.setY(y - 1);
				this.getNextCrossRoadDirection(nextMove, cart);
				break;
			}
			case BOTTOM: {
				nextMove = mine[y + 1][x];
				cart.setY(y + 1);
				this.getNextCrossRoadDirection(nextMove, cart);
				break;
			}
			case RIGHT: {
				nextMove = mine[y][x + 1];
				cart.setX(x + 1);
				this.getNextCrossRoadDirection(nextMove, cart);
				break;
			}
			case LEFT: {
				nextMove = mine[y][x - 1];
				cart.setX(x - 1);
				this.getNextCrossRoadDirection(nextMove, cart);
				break;
			}
			default:
				break;
			}
			result = this.checkCrash();
			if (result != null) {
				showCrash(result);

			}

			this.animate();
		}
	}

	private void removeCrashedCarts(int x, int y) {
		List<Cart> copyCarts = new ArrayList(carts);

		for (Cart cart : copyCarts) {
			if ((cart.getX() == x) && (cart.getY() == y)) {
				crashedCarts.add(cart);
			}
		}

		for (Cart cart : crashedCarts) {
			carts.remove(cart);
		}

	}

	public void getResult(String fileName) throws IOException, InterruptedException {
		this.init(fileName);
		this.getAllCarts();
		String result = "";

		while (true) {
			Thread.sleep(50);
			result = this.checkCrash();
			if (carts.size() == 1) {
				System.out.println(carts.get(0));
				break;
			}
			if (result != null) {
				showCrash(result);
				for (Cart cart : carts) {
					System.out.println(cart);
				}

			} else {
				makeOneStep();
			}
		}
		System.out.println(step);
		System.out.println(this.checkCrash());
	}

	private void showCrash(String result) {
		int x = Integer.parseInt(result.split(",")[0]);
		int y = Integer.parseInt(result.split(",")[1]);
		panel.setCrashXY(x, y);
		frame.repaint();
	}

	private void animate() {
		panel.setCarts(carts);
		frame.repaint();
	}

}
