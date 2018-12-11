package adventofcode2018.task11;

public class Task11 {

	final int serialNumber = 7672;
	final int maxX = 300;
	final int maxY = 300;

	private int[][] matrix = new int[maxX][maxY];

	public int getFuelLvl(int x, int y) {
		int id = x + 10;
		int power = ((id * y + serialNumber) * id);
		String number = String.valueOf(power);
		int hundred = Integer.parseInt(number.toCharArray()[number.length() - 3] + "");
		return hundred - 5;
	}

	private void populateMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			int row = i + 1;
			for (int j = 0; j < matrix.length; j++) {
				int col = j + 1;
				matrix[j][i] = getFuelLvl(row, col);
			}
		}
	}

	private int getPower(int x, int y, int size) {
		int power = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				power += matrix[i][j];
			}
		}

		return power;
	}

	private String maxPower() {

		String maxPowerCoord = "";
		int max = Integer.MIN_VALUE;
		for (int k = 0; k < 300; k++) {
			long start = System.currentTimeMillis();
			for (int i = 0; i < matrix.length - k; i++) {
				for (int j = 0; j < matrix.length - k; j++) {
					int currentPower = getPower(i, j, k);
					if (currentPower > max) {
						max = currentPower;
						maxPowerCoord = j + 1 + "," + (i + 1) + "," + (k);
					}
				}
			}
			long stop = System.currentTimeMillis();
			System.out.println(k + " " + " processing: " + (stop - start));
		}

		return maxPowerCoord;
	}

	public void getResult() {
		this.populateMatrix();
		System.out.println(maxPower());

//		JFrame frame = new JFrame("Elvs resque");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		DrawingPanel panel = new DrawingPanel(matrix);
//		frame.add(panel);
//		frame.setSize(maxX, maxY);
//		frame.setVisible(true);

	}

	public void showMatrix() {
		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				System.out.printf("%4s ", (matrix[i][j] + "|"));
			}
			System.out.println();

		}
	}

}
