package adventofcode2018.app;

import java.io.IOException;

import adventofcode2018.task1.Task1;
import adventofcode2018.task2.Task2;
import adventofcode2018.task3.Task3;

public class App {

	public static void main(String[] args) throws IOException {
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		Task3 task3 = new Task3();
//		 System.out.println(task1.getValue1());
//		 System.out.println(task1.getValue2());
//		 System.out.println(task2.getCheckSum());

		// System.out.println(task2.getKey());
		System.out.println(task3.getNumberOverLaps());
		System.out.println(task3.findUnOverId());

	}

}
