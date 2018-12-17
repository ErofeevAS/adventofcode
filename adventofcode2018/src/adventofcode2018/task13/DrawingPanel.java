package adventofcode2018.task13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private char[][] matrix;
	private int maxX;
	private int maxY;
	private int crashX;
	private int crashY;
	List<Cart> carts = new ArrayList<Cart>();

	public DrawingPanel(char[][] matrix) {
		super();
		this.matrix = matrix;
		maxX = matrix[0].length;
		maxY = matrix.length;
	}

	private void drawMap(Graphics2D graphics2d) {
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, maxX * 5, maxY * 5);
		graphics2d.setPaint(Color.BLACK);

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				char symbol = matrix[y][x];
				int x1 = 5 * x;
				int y1 = 5 * y;
				switch (symbol) {
				case '|': {
					graphics2d.drawLine(x1 + 2, y1, x1 + 2, y1 + 4);
				}
					break;
				case '-': {
					graphics2d.drawLine(x1, y1 + 2, x1 + 4, y1 + 2);
				}
					break;
				case '/': {
					graphics2d.drawLine(x1 + 2, y1 + 2, x1 + 2, y1 + 2);
				}
					break;
				case '\\': {
					graphics2d.drawLine(x1 + 2, y1 + 2, x1 + 2, y1 + 2);
				}
					break;
				case '+': {
					graphics2d.drawLine(x1 + 1, y1 + 2, x1 + 3, y1 + 2);
					graphics2d.drawLine(x1 + 2, y1 + 1, x1 + 2, y1 + 3);
				}
					break;
				default:
					break;
				}
			}
		}
	}

	public void drawCarts(Graphics2D graphics2d) {
		graphics2d.setPaint(Color.RED);
		for (Cart cart : carts) {
			int x = 5 * cart.getX();
			int y = 5 * cart.getY();
			graphics2d.drawRect(x, y, 3, 3);
		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		this.drawMap(graphics2d);
		this.drawCarts(graphics2d);
		this.drawCartsCrash(graphics2d);

	}

	private void drawCartsCrash(Graphics2D graphics2d) {
		graphics2d.setPaint(Color.BLUE);
		graphics2d.drawRect(crashX, crashY, 5, 5);

	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;

	}

	public void setCrashXY(int x, int y) {
		this.crashX = 5 * x;
		this.crashY = 5 * y;
	}

}
