package adventofcode2018.task1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import adventofcode2018.FileReader;

public class Task1 {

	public int getValue1() throws IOException {
		String[] data = FileReader.readFromFile("input1.txt");
		int[] dataInt = new int[data.length];
		int result = 0;
		for (int i = 0; i < dataInt.length; i++) {
			dataInt[i] = Integer.parseInt(data[i]);
			result = result + dataInt[i];
		}
		return result;
	}

	public int getValue2() throws IOException {
		String[] dataString = FileReader.readFromFile("input1.txt");
		int[] data = new int[dataString.length];
		int result = 0;
		Set<Integer> results = new HashSet<Integer>();
		results.add(result);

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			i = i % (data.length);
			// }
			data[i] = Integer.parseInt(dataString[i]);
			result = result + data[i];

			if (!results.add(result)) {
				return result;
			}

		}
		return result;

	}

	public int getValue2(int[] data) throws IOException {
		int result = 0;
		Set<Integer> results = new HashSet<Integer>();
		results.add(result);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			i = i % (data.length);
			result = result + data[i];

			if (!results.add(result)) {
				return result;
			}

		}
		return result;

	}

}
