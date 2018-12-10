package adventofcode2018.task10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import adventofcode2018.FileReader;

public class Task10 {

	List<Point> points = new ArrayList<Point>();
	List<Point> newPoints = new ArrayList<Point>();
	private int maxX = Integer.MIN_VALUE;
	private int maxY = Integer.MIN_VALUE;

	private void init(String fileName) throws IOException {
		String[] data = FileReader.readFromFile(fileName);
		int X = 0;
		int Y = 0;
		int speedX = 0;
		int speedY = 0;
		for (int i = 0; i < data.length; i++) {
			int cnt = 0;
			Pattern p = Pattern.compile("(\\<(.*?)\\>)");
			Matcher m = p.matcher(data[i]);
			while (m.find()) {
				String str = (m.group(1));
				str = str.replace("<", "");
				str = str.replace(">", "");
				str = str.replace(" ", "");

				String[] params = str.split("\\,");

				if (cnt == 0) {
					X = Integer.parseInt(params[0]);
					Y = Integer.parseInt(params[1]);
				}
				if (cnt == 1) {
					speedX = Integer.parseInt(params[0]);
					speedY = Integer.parseInt(params[1]);
				}
				cnt++;

			}
			points.add(new Point(X, Y, speedX, speedY));

			System.out.println();
		}
	}

	private List<Point> getTenThousandItaration(int itarations) {
		newPoints = new ArrayList<>(points);
		for (int i = 0; i < itarations; i++) {
			for (Point point : newPoints) {
				int newX = point.getX() + point.getSpeedX();
				int newY = point.getY() + point.getSpeedY();
				point.setX(newX);
				point.setY(newY);

			}
		}

		this.findMaxCoords();
		return newPoints;

	}

	private void findMaxCoords() {
		for (Point point : newPoints) {
			if (point.getX() > maxX) {
				maxX = point.getX();
			}
			if (point.getY() > maxY) {
				maxY = point.getY();
			}
		}
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public List<Point> getNewPoints() {
		return this.newPoints;
	}

	public void doOneItaration() {
		for (Point point : newPoints) {
			int newX = point.getX() + point.getSpeedX();
			int newY = point.getY() + point.getSpeedY();
			point.setX(newX);
			point.setY(newY);
		}

	}

	public void getResult(String fileName) throws IOException, InterruptedException {
		init(fileName);
		getTenThousandItaration(10239);
		JFrame frame = new JFrame("Elvs resque");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			Thread.sleep(1000);

			List<Point> newPoints = getNewPoints();
			DrawingPanel panel = new DrawingPanel(newPoints);
			frame.add(panel);
			frame.setSize(2 * getMaxX(), 2 * getMaxY());
			frame.setVisible(true);
			doOneItaration();

		}
	}

}
