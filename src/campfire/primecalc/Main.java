package campfire.primecalc;

import java.util.Scanner;

public class Main {

	public static void main(final String[] args) {

		Scanner in = new Scanner(System.in);
		Main main = new Main();

		int questionsInQuiz = main.fetchNumber(in, "Please enter number of questions: ");
		int anwersPerQuestion = main.fetchNumber(in, "Enter number of answers per question: ");
		int calculationSets = main.fetchNumber(in, "Please enter number of calculation sets: ");

		in.close();

		for (int i = 0; i < calculationSets; i++) {
			PrimeResultSet results = new PrimeResultSet(questionsInQuiz, anwersPerQuestion);
			System.out.println(results.toString());
			System.out.println("-------------------");
		}
	}

	private int fetchNumber(final Scanner in, final String message) {
		System.out.print(message);
		int number = Integer.valueOf(in.nextLine());

		return number;
	}
}
