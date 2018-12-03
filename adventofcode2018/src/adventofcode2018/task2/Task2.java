package adventofcode2018.task2;

import java.io.IOException;

import adventofcode2018.FileReader;

public class Task2 {

	public int getCheckSum() throws IOException {
		int checksum = 0;
		int db = 0;
		int tr = 0;

		String[] dataString = FileReader.readFromFile("input2.txt");

		for (int i = 0; i < dataString.length; i++) {
			int doubleRepeat = checkRepeat(dataString[i], 2);
			int tripleRepeat = checkRepeat(dataString[i], 3);
			db = db + doubleRepeat;
			tr = tr + tripleRepeat;
		}
		checksum = db * tr;
		return checksum;

	}

	public String getKey() throws IOException {
		String[] data = FileReader.readFromFile("input2.txt");
		String key;
		for (int i = 0; i < data.length - 1; i++) {
			String str = data[i];
			key = compareTwoSring(str, data);
			if (key != null) {
				return key;
			}
		}
		return null;
	}

	private String compareTwoSring(String string, String[] data) {

		for (int i = 0; i < data.length; i++) {
			int count = 0;
			int position = 0;
			for (int j = 0; j < string.length(); j++) {
				if (string.charAt(j) != data[i].charAt(j)) {
					count++;
					position = j;
				}
			}
			if (count == 1) {
				String str = string.substring(0, position) + string.substring(position + 1, string.length());
				return str;
			}
		}
		return null;

	}

	private int checkRepeat(String str, int numberRepeat) {

		int number = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char seekChar = chars[i];
			int count = 0;
			for (int j = 0; j < chars.length; j++) {
				if (chars[j] == seekChar) {
					count++;

				}
			}
			if (count == numberRepeat) {
				number++;
				return 1;
			}
		}
		return (number / numberRepeat);

	}

}
