package adventofcode2018.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import adventofcode2018.task5.Task5;

public class Test5 {

	@Test
	public void testGetCapcha() throws IOException, ParseException {

		int firstExpected = 10;
		int secondExpected = 4;

		Task5 task5 = new Task5();

		assertEquals(firstExpected, task5.getResult("input5_test.txt"));
		System.out.println("first test done");

		assertEquals(secondExpected, task5.getResult2("input5_test.txt"));
		System.out.println("first test done");

	}

}
