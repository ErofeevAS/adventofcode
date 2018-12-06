package adventofcode2018.app;

import java.io.IOException;
import java.text.ParseException;

import adventofcode2018.task1.Task1;
import adventofcode2018.task2.Task2;
import adventofcode2018.task3.Task3;
import adventofcode2018.task4.Task4;
import adventofcode2018.task5.Task5;
import adventofcode2018.task6.Task6;

public class App {

	public static void main(String[] args) throws IOException, ParseException {
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		Task3 task3 = new Task3();
		Task4 task4 = new Task4();
		Task5 task5 = new Task5();
		Task6 task = new Task6();
		System.out.println(	task.getResult("input6.txt"));			
		System.out.println("---------------------");
		
		System.out.println(task.getResult2(10000));
		
		
				
		

		

	}

}
