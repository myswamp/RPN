package com.xxx;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		RPNCalculator c = new RPNCalculator();
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String expression = reader.nextLine();
			if (expression.equals("quit"))
				break;
			System.out.println(c.process(expression));
		}
		reader.close();
	}
}
