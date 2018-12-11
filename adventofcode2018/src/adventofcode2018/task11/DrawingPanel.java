package adventofcode2018.task11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	int[][] matrix;

	public DrawingPanel(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.BLACK);
		graphics2d.fillRect(0, 0, getWidth(), getHeight());
		graphics2d.setPaint(Color.GREEN);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int green = (matrix[i][j] + 5) * 28;
				graphics2d.setPaint(new Color(0, green, 0));
				graphics2d.drawLine(i, j, i, j);
			}
		}

	}

}
