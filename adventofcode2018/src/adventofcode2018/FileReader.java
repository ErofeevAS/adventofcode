package adventofcode2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

	public static String[] readFromFile(String filename) throws IOException {
		int i = 0;
		String[] lines = new String[getLines(filename)];
		try {

			File file = new File(filename);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				lines[i] = line;
				i++;
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lines;
	}

	private static int getLines(String filename) {
		int i = 0;
		try {

			File file = new File(filename);
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				input.nextLine();
				i++;
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}

}
