package adventofcode2018.task10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	List<Point> points = new ArrayList<Point>();

	public DrawingPanel(List<Point> list) {
		super();
		this.points = list;
	}

	public void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.BLACK);
		graphics2d.fillRect(0, 0, getWidth(), getHeight());
		graphics2d.setPaint(Color.GREEN);

		for (Point point : points) {
			graphics2d.drawLine(point.getX(), point.getY(), point.getX(), point.getY());
		}

	}

}
