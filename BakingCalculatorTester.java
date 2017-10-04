
/**
 * Test program for Assignment 1 Baking Calculator by Martin Hock
 * You may only use this program as a student of Martin Hock, CS 142 Fall 2017.
 * Directions: Run this program from the same workspace as your BakingCalculator.java file.
 * Please run it for the first time with declarations of int cookieCount = 24 and int loafCount = 1 as specified.
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BakingCalculatorTester {

	public static int getCount(String source, String countString, int initialValue) {

		int offset = source.indexOf(countString);
		if (offset == -1) {
			System.out.println("Couldn't find " + countString
					+ " declaration! Please add one to your program! It should look like this:");
			System.out.println(countString + " = " + initialValue + ";");
			System.exit(-1);
		}

		if (source.lastIndexOf(countString) != offset) {
			System.out.println("Detected multiple " + countString + " declarations! ");
		}
		String remainingSource = source.substring(offset + countString.length());
		int eqIndex = remainingSource.indexOf('=');
		if (eqIndex == -1 || remainingSource.substring(0, eqIndex).trim().length() > 0) {
			System.out.println("The " + countString
					+ " declaration doesn't appear to contain an initialization! It should look like this:");
			System.out.println(countString + " = " + initialValue + ";");
			System.out.println("Please fix this problem!");
			System.exit(-1);
		}
		remainingSource = remainingSource.substring(eqIndex + 1);
		remainingSource = remainingSource.substring(0, remainingSource.indexOf(";"));
		remainingSource = remainingSource.trim();
		try {
			return Integer.parseInt(remainingSource);
		} catch (NumberFormatException e) {
			System.out.println("Couldn't recognize " + countString + " initialized value '" + remainingSource
					+ "' as an integer!");
			try {
				Double.parseDouble(remainingSource);
				System.out.println("It does look like a double - please make it integer formatted, no decimal points!");
			} catch (NumberFormatException e2) {
				System.out.println("I don't think it looks like a double (floating point number), either!");
			}
			System.out.println("Please fix this problem!");
		}
		System.exit(-2);
		return 0; // Unreachable statement
	}

	public static void main(String[] args) throws IOException {
		int[] cookieCounts = { 24, 39, 80, 96, 97 };
		int[] loafCounts = { 1, 1, 8, 10, 10 };
		int[][] ingredientCounts = { { 1, 1, 1, 1, 1, 1, 1, 2, 1 }, { 1, 1, 1, 1, 1, 1, 1, 2, 2 },
				{ 1, 1, 1, 2, 1, 5, 3, 16, 3 }, { 2, 1, 1, 2, 2, 6, 3, 20, 3 }, { 2, 1, 1, 3, 2, 6, 3, 20, 3 } };
		double[] finalPrices = { 20.75, 24.74, 51.30, 58.02, 62.01 };
		int[] scores = { 0, 60, 70, 80, 90 };

		// Read in BakingCalculator.java
		String source = null;
		try {
			source = new String(Files.readAllBytes(Paths.get("BakingCalculator.java")));
		} catch (Exception e) {
			System.out.println(
					"Couldn't find BakingCalculator.java! Run this from the same Eclipse project as BakingCalculator.");
			return;
		}

		int cookieCount = getCount(source, "int cookieCount", cookieCounts[0]);
		int loafCount = getCount(source, "int loafCount", loafCounts[0]);
		int[] ingredientsCount = null;
		double finalPrice = -1;
		int comboIndex;
		for (comboIndex = 0; comboIndex < cookieCounts.length; comboIndex++) {
			if (cookieCount == cookieCounts[comboIndex] && loafCount == loafCounts[comboIndex]) {
				ingredientsCount = ingredientCounts[comboIndex];
				finalPrice = finalPrices[comboIndex];
				break;
			}
		}
		if (ingredientsCount == null) {
			System.out.println("Sorry, I don't have a test for those values of cookieCount = " + cookieCount
					+ " and loafCount = " + loafCount + "! Start with the ones from the assignment sheet!");
			return;
		}
		System.out
				.println("Testing with your values of cookieCount = " + cookieCount + " and loafCount = " + loafCount);
		String[] lines = { "Shopping list for " + cookieCount + " cookie(s) and " + loafCount + " loaf(s) of bread:",
				ingredientsCount[0] + " bag(s) of flour", ingredientsCount[1] + " package(s) of salt",
				ingredientsCount[2] + " box(es) of baking soda", ingredientsCount[3] + " bottle(s) of vanilla extract",
				ingredientsCount[4] + " carton(s) of eggs", ingredientsCount[5] + " bag(s) of sugar",
				ingredientsCount[6] + " package(s) of butter", ingredientsCount[7] + " banana(s)",
				ingredientsCount[8] + " bag(s) of chocolate chips", "Total cost:" };

		PrintStream oldOut = System.out;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		BakingCalculator.main(new String[0]);
		System.setOut(oldOut);
		Scanner scanner = new Scanner(new String(stream.toByteArray()));
		scanner.useDelimiter("[$]");
		boolean error = false;
		boolean ec = true;
		for (int i = 0; i < lines.length; i++) {
			if (!scanner.hasNext()) {
				if (i == 0) {
					System.out.println("Your program doesn't output anything! Please look at the assignment.");
				} else {
					System.out.println("Your program only outputs " + i + " line(s), it should output " + lines.length
							+ " - check the assignment");
				}
				error = true;
				break;
			}
			if (i < lines.length - 1) {
				String line = scanner.nextLine();
				if (!lines[i].equalsIgnoreCase(line)) {
					System.out.println("Line " + (i + 1) + ": expected '" + lines[i] + "', got '" + line + "'");
					error = true;
				}
			} else {
				String line = scanner.next().trim();
				if (!scanner.hasNext()) {
					System.out.println("Missing dollar sign on last line!");
					error = true;
					break;
				}
				String price = scanner.next().trim();
				if (!lines[i].equalsIgnoreCase(line)) {
					System.out
							.println("Final line before dollar sign: expected '" + lines[i] + "', got '" + line + "'");
					error = true;
				}
				try {
					double d = Double.parseDouble(price);
					if (Math.abs(d - finalPrice) > 0.01) {
						System.out.println("Price off by more than a cent: expected " + finalPrice + ", got " + price);
						error = true;
					}
					if (price.length() - price.indexOf(".") != 3) {
						System.out.println("Your price wasn't formatted to get the extra credit! Notice that it looked like this: "+price);
						System.out.println("It doesn't have two digits after the decimal point.");
						ec = false;
					}
				} catch (Exception e) {
					System.out.println("Price does not look like a valid number!");
					error = true;
				}
			}
		}
		if (!error) {
			if (!ec) System.out.println("Other than extra credit, no errors found for this example.");
			else System.out.println("No errors found for this example.");
			if (comboIndex < cookieCounts.length - 1) {
				System.out.println("Now modify the two variable declarations in your program to say cookieCount = " + cookieCounts[comboIndex + 1]
						+ " and loafCount = " + loafCounts[comboIndex + 1] + " then run this test program again.");
			} else {
				System.out.println("You tried all the values I know about!");
				System.out.println(
						"If you started with cookieCount and loafCount having the values from the assignment sheet (24 and 1) and ran this test program on each example as directed, you earned 100/100 on the assignment.");
				System.out.println(
						"NOTE: This program doesn't check for academic dishonesty which could affect your score, please make sure you know the syllabus policy.");
			}
		} else {
			System.out.println(
					"Please fix the above errors in your program so the output format and values match what I expect! Check your calculations and values, no decimal points and make sure you aren't incorrectly rounding down (integer division or cast without Math.ceil)!");
			if (comboIndex == 0) {
				System.out.println(
						"It looks like you didn't get the first one right so please get it to work! You may not receive points for this assignment otherwise!");
			} else {
				System.out.println(
						"If you started with cookieCount and loafCount having the values from the assignment sheet and ran this test program on each example as directed, you earned at least "
								+ scores[comboIndex] + "/100 on the assignment so far. Keep going!");
				System.out.println(
						"NOTE: This program doesn't check for academic dishonesty which could affect your score, please make sure you know the syllabus policy.");
			}
		}

	}

}
