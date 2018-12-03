package adventofcode2018.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import adventofcode2018.task1.Task1;

public class Test1 {

	@Test
	public void testGetCapcha() throws IOException {
		int[] first = {1,-1};
		int firstExpected = 0;
		int[] second ={+3, +3, +4, -2, -4};
		int secondExpected = 10;
		int[] third = {-6, +3, +8, +5, -6};
		int thirdExpected = 5;
		int[] fourth = {+7, +7, -2, -7, -4};
		int fourthExpected = 14;

		Task1 task1 = new Task1();

		assertEquals(firstExpected, task1.getValue2(first));
		System.out.println("first test done");
		assertEquals(secondExpected, task1.getValue2(second));
		System.out.println("second test done");
		assertEquals(thirdExpected, task1.getValue2(third));
		System.out.println("third test done");
		assertEquals(fourthExpected, task1.getValue2(fourth));
		System.out.println("fourth test done");

	}

	

}
