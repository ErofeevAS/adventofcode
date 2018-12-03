package adventofcode2018.task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adventofcode2018.FileReader;

public class Task3 {

	private List<Table> tables = new ArrayList<Table>();
	private int[][] matrix = createMatrix(2000, 2000);

	private int[][] createMatrix(int x, int y) {
		return new int[x][y];

	}

	private int findNotOneValue(int[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] > 1) {
					count++;
				}
			}
		}
		return count;
	}

	private void addTableInMatrix(Table table) {

		int x0 = table.getX0();
		int y0 = table.getY0();
		int x = table.getX();
		int y = table.getY();
		for (int i = x0; i < x + x0; i++) {
			for (int j = y0; j < y + y0; j++) {

				matrix[i][j] = matrix[i][j] + 1;
			}
		}
	}
	
	
	public int getNumberOverLaps() throws IOException {
		String[] data = FileReader.readFromFile("input3.txt");

		for (int i = 0; i < data.length; i++) {

			String[] fields = data[i].split("\\s+");
			String[] idString = fields[0].split("#");
			String[] startPoints = fields[2].split(",");
			String[] tableSzie = fields[3].split("x");
			int id = Integer.parseInt(idString[1]);
			int X0 = Integer.parseInt(startPoints[0]);
			int Y0 = Integer.parseInt(startPoints[1].substring(0, startPoints[1].length() - 1));
			int X = Integer.parseInt(tableSzie[0]);
			int Y = Integer.parseInt(tableSzie[1]);
			Table table = new Table(id, X0, Y0, X, Y);
			tables.add(table);
			addTableInMatrix(table);
		}

		return findNotOneValue(matrix);
	}
	

	public int findUnOverId() {

		for (Table table : tables) {
			int sum = 0;
			int x0 = table.getX0();
			int y0 = table.getY0();
			int x = table.getX();
			int y = table.getY();
			int square = x * y;
			for (int i = x0; i < x + x0; i++) {
				for (int j = y0; j < y + y0; j++) {
					sum = sum + matrix[i][j];
				}
			}
			if (sum == square) {
				return table.getId();
			}
		}
		return 0;
	}
	

	

}
