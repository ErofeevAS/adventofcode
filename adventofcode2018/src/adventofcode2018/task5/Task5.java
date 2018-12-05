package adventofcode2018.task5;

import java.io.IOException;

import adventofcode2018.FileReader;

public class Task5 {
	String pattern = "";

	private String simplifyPolymer(String data) {
		String currentData = data;

		for (int i = 0; i < currentData.length() - 1; i++) {
			char char1 = currentData.charAt(i);
			char char2 = currentData.charAt(i + 1);
			boolean flagStop = true;

			if (Character.isUpperCase(char1)) {
				if (Character.isLowerCase(char2) && ((char1) == (Character.toUpperCase(char2)))) {
					String sub1 = currentData.substring(0, i);
					String sub2 = currentData.substring(i + 2);
					currentData = sub1 + sub2;
					flagStop = false;
					i = -1;
				}
			}

			if (Character.isLowerCase(char1)) {
				if (Character.isUpperCase(char2) && ((Character.toUpperCase(char1)) == (char2))) {
					String sub1 = currentData.substring(0, i);
					String sub2 = currentData.substring(i + 2);
					currentData = sub1 + sub2;
					flagStop = false;
					i = -1;
				}
			}
			if ((flagStop) && (i == currentData.length() - 2)) {
				break;
			}
		}

		return currentData;
	}

	public long getResult(String fileName) throws IOException {

		String[] dataString = FileReader.readFromFile(fileName);
		String data = dataString[0];
		String result = simplifyPolymer(data);
		return result.length();
	}

	public int getResult2(String fileName) throws IOException {
		String[] dataString = FileReader.readFromFile(fileName);
		String data = dataString[0];
		String pattern = "";
		int min = Integer.MAX_VALUE;
		char minChar = 0;
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (char c : alphabet) {
			pattern = "[" + Character.toUpperCase(c) + c + "]";
			String dataCleared = data.replaceAll(pattern, "");
			int size = this.simplifyPolymer(dataCleared).length();
			if (size < min) {
				min = size;
				minChar = c;
			}
		}

		pattern = "[" + Character.toUpperCase(minChar) + minChar + "]";
		String dataCleared = data.replaceAll(pattern, "");
		int result = this.simplifyPolymer(dataCleared).length();
		return result;
	}

}
