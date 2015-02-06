package campfire.primecalc;

import java.util.Scanner;

public class Main {

	private final static int DEFAULT_SIZE = 4;

	public static void main(final String[] args) {

		Scanner in = new Scanner(System.in);
		Main main = new Main();

		// enter number (of questions)
		int numberOfQ = main.fetchNumber(in);
		int numberOfTurns = main.fetchTurns(in);

		in.close();

		for (int i = 0; i < numberOfTurns; i++) {
			PrimeResultSet foo = new PrimeResultSet(numberOfQ, DEFAULT_SIZE);
			System.out.println(foo.toString());
			System.out.println("-------------------");
		}
	}

	private int fetchNumber(final Scanner in) {

		System.out.print("Please enter number of questions: ");
		int number = Integer.valueOf(in.nextLine());

		return number;
	}

	private int fetchTurns(final Scanner in) {

		int number = 1;
		System.out.print("Please enter number of turns: ");
		number = Integer.valueOf(in.nextLine());

		return number;
	}

}
