package adventofcode2018.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import adventofcode2018.task4.Task4;

public class Test4 {

	@Test
	public void testGetCapcha() throws IOException, ParseException {	
		int firstExpected = 240;		
		int secondExpected = 4455;
		Task4 task4 = new Task4();

		assertEquals(firstExpected, task4.getResult("input4_test.txt"));
		System.out.println("first test done");
		assertEquals(secondExpected, task4.getResult2());
		System.out.println("second test done");

	}

	

}
