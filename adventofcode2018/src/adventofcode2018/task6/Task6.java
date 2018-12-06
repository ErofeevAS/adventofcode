package adventofcode2018.task6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import adventofcode2018.FileReader;

public class Task6 {

	private int maxX = 0;
	private int maxY = 0;
	private int max = 0;
	private String[][] matrix;
	private List<Coordinates> field = new ArrayList<Coordinates>();
	String[] alphabet;
	Set<String> alphabet1 = new HashSet<String>();

	private void populateMatrix() {

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				matrix[i][j] = ".";
			}
		}

		for (int i = 0; i < field.size(); i++) {
			int x = field.get(i).getX();
			int y = field.get(i).getY();
			String ch = field.get(i).getCh();
			matrix[y][x] = ch;
		}
	}

	private void init(String fileName) throws IOException {
		String[] dataString = FileReader.readFromFile(fileName);
		alphabet = new String[dataString.length];
		for (int i = 0; i < dataString.length; i++) {
			alphabet[i] = (i + 1) + "A";
			alphabet1 = new HashSet<>(Arrays.asList(alphabet));

		}
		for (int i = 0; i < dataString.length; i++) {
			int x = Integer.parseInt(dataString[i].split(", ")[0]);
			int y = Integer.parseInt(dataString[i].split(", ")[1]);
			String ch = Character.toUpperCase(alphabet[i].charAt(0)) + "" + alphabet[i].charAt(1);
			if (x > maxX) {
				maxX = x + 1;
			}
			if (y > maxY) {
				maxY = y + 1;
			}
			if (maxY > maxX) {
				max = maxY;
			} else {
				max = maxX;
			}
			field.add(i, new Coordinates(x, y, ch));

		}
		matrix = new String[max][max];
		populateMatrix();
	}

	private int getMinDistance(int x0, int y0, Coordinates coord) {
		int x1 = coord.getY();
		int y1 = coord.getX();
		int distance = Math.abs(x1 - x0) + Math.abs(y1 - y0);
		return distance;

	}

	private boolean isAllDistanceLessThan(int x0, int y0, int limit) {
		int distance = 0;
		int sum = 0;
		for (int i = 0; i < field.size(); i++) {
			distance = Math.abs(field.get(i).getX() - x0) + Math.abs(field.get(i).getY() - y0);
			sum += distance;
		}
		if (sum < limit) {
			return true;
		}
		return false;

	}

	private int numberMatch(List<Integer> list, int distance) {
		int cnt = 0;
		for (Integer integer : list) {
			if (integer == distance) {
				cnt++;
			}
		}
		return cnt;
	}

	private Set<String> charsForSearching() {
		for (int i = 0; i < max; i++) {
			String ch1 = matrix[0][i];
			String ch2 = matrix[max - 1][i];
			String ch3 = matrix[i][0];
			String ch4 = matrix[i][max - 1];
			alphabet1.remove(ch1);
			alphabet1.remove(ch2);
			alphabet1.remove(ch3);
			alphabet1.remove(ch4);

		}
		return alphabet1;

	}

	private int findMaxSum() {
		Set<String> alphabet = charsForSearching();
		int maxSum = 0;
		for (String c : alphabet) {
			int sum = 0;
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < max; j++) {
					if (matrix[i][j].equals(c)) {
						sum++;
					}
				}
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

	private void buildFullMatrix() {
		String ch = "";
		int minDistance;
		for (int row = 0; row < max; row++) {
			minDistance = Integer.MAX_VALUE;
			for (int col = 0; col < max; col++) {
				ch = ".";
				List<Integer> minDistances = new ArrayList<Integer>();
				minDistance = Integer.MAX_VALUE;
				for (int k = 0; k < field.size(); k++) {
					int newMinDistance = getMinDistance(row, col, field.get(k));
					minDistances.add(newMinDistance);
					if (minDistance > newMinDistance) {
						ch = field.get(k).getCh();
						minDistance = newMinDistance;
					}

				}
				if (numberMatch(minDistances, minDistance) > 1) {
					matrix[row][col] = ".";
				} else {
					matrix[row][col] = Character.toLowerCase(ch.charAt(0)) + "" + ch.charAt(1);
				}
			}
		}
		for (int i = 0; i < field.size(); i++) {
			int x = field.get(i).getX();
			int y = field.get(i).getY();
			String ch1 = field.get(i).getCh();
			matrix[y][x] = ch1;
		}
	}

	public int getResult(String fileName) throws IOException {
		this.init(fileName);
		buildFullMatrix();
		return findMaxSum();
	}

	public void showMatrix() {
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				System.out.printf("%4s ", (matrix[i][j] + "|"));
			}
			System.out.println();

		}
	}

	public int getResult2(int limit) {
		int cnt = 0;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (isAllDistanceLessThan(i, j, limit)) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
