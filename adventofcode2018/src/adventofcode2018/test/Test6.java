package adventofcode2018.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import adventofcode2018.task6.Task6;

public class Test6 {

	@Test
	public void testGetCapcha() throws IOException, ParseException {

		int firstExpected = 17;

		Task6 task = new Task6();

		assertEquals(firstExpected, task.getResult("input6_test.txt"));
		System.out.println("first test done");

	}

}
