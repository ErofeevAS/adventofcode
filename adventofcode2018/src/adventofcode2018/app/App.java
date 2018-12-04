package adventofcode2018.app;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import adventofcode2018.task1.Task1;
import adventofcode2018.task2.Task2;
import adventofcode2018.task3.Task3;
import adventofcode2018.task4.PieceOfScheduler;
import adventofcode2018.task4.Task4;

public class App {

	public static void main(String[] args) throws IOException, ParseException {
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		Task3 task3 = new Task3();
		Task4 task4 = new Task4();
//		 System.out.println(task1.getValue1());
//		 System.out.println(task1.getValue2());
//		 System.out.println(task2.getCheckSum());

		// System.out.println(task2.getKey());
		// System.out.println(task3.getNumberOverLaps());
		// System.out.println(task3.findUnOverId());
		List<PieceOfScheduler> scheduler = task4.getScheduler();

		
//		Pattern p = Pattern.compile("^ Guard #(\\d{4}|\\d{3}|\\d{2}|\\d{1}) begins shift");
//		String message = " Guard #659 begins shift";
//
//		Matcher m = p.matcher(message);
//
//		System.out.println(m.matches());

		System.out.println(task4.getResult("input4.txt"));
		System.out.println(task4.getResult2());

	}

}
