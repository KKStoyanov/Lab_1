import java.util.Scanner;

//Names: Kalloyan Stoyanov, Kathleen Stamos, Joseph Stramandinoli
public class Lab_1 {

	public static void main(String[] args) {
		// Scanner Object.
		Scanner input = new Scanner(System.in);

		// Questions which the user answers and their input is saved to various
		// variables.
		System.out.println("How many years do you expect to work:");
		double expectedYears = input.nextDouble();

		// The annual return must be between 0 and 20%. If it is not then the
		// while loop will make the user enter in another value.
		System.out.println("What is your expected average return on investment?");
		double annualReturn = input.nextDouble();
		while (annualReturn > 20 || annualReturn <= 0) {
			System.out.println(
					"Your expected average return should be less than 20. What is your expected average return on investment?");
			annualReturn = input.nextDouble();
		}

		System.out.println("How long do you want to draw money for?");
		double retiredYears = input.nextDouble();

		System.out.println("What is your required income?");
		double requiredIncome = input.nextDouble();

		System.out.println("What is your expected monthly SSI?");
		double expectedSSIReturn = input.nextDouble();

		// The retired return must be between 0 and 3%. If it is not then the
		// while loop will make the user enter in another value.
		System.out.println("What is your annual return during retirement?");
		double retiredReturn = input.nextDouble();
		while (retiredReturn > 3 || retiredReturn <= 0) {
			System.out.println(
					"Your expected average return should be less than 3. What is your expected average return on investment?");
			retiredReturn = input.nextDouble();

		}
		// Prints the total amount of money the user must save and how much they
		// must save per month to the console.
		double tSavings = totalSavings(requiredIncome, expectedSSIReturn, retiredReturn, retiredYears);
		double mSavings = monthlySavings(tSavings, annualReturn, expectedYears);
		System.out.printf("You must save %.2f dollars every month and a total of %.2f dollars", mSavings, tSavings);
		
		//Closes the Scanner.
		input.close();
	}

	// Function that calculates the total amount of money the user must save.
	public static double totalSavings(double rI, double monthlySSI, double retiredReturn, double retiredYears) {
		return (rI - monthlySSI) * (1 - (1 / Math.pow((1 + (retiredReturn / 100) / 12), (12 * retiredYears))))
				/ (retiredReturn / 100 / 12);
	}

	// Function that calculates the amount of money the user must save per month.
	public static double monthlySavings(double tS, double annualReturn, double yearsWorked) {
		return tS * ((annualReturn / 100) / 12) / (Math.pow((1 + (annualReturn / 100) / 12), (yearsWorked * 12)) - 1);
	}

}
