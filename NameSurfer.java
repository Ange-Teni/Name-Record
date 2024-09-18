/*
 * Student information for assignment: Replace <NAME> in the following with your
 * name. You are stating, on your honor you did not copy any other code on this
 * assignment and have not provided your code to anyone. 
 * 
 * On my honor, <Angel>, this programming assignment is my own work 
 * and I have not provided this code
 * to any other student. 
 * 
 * UTEID: aoo795
 * email address: angel-ogungbemi@utexas.edu
 * Number of slip days I am using:1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSurfer {

	// CS314 students, explain your menu option 7 here:

//	displays names based on the max rank and the decade for the rank 
//	that the name shows up in these depend on the users input so the uniqueness of 
//	the names depends on the user. 

	// CS314 students, Explain your interesting search / trend here:
	// Theres a alot more A names then expected. And my name was popular in 2010.

	// CS314 students, add test code for NameRecord class here:
	public static void myTests() {
		String name = "Angel";
		int base = 2000;
		ArrayList<Integer> rank = new ArrayList<Integer>();
		NameRecord names = new NameRecord(name, base, rank);

		// test 1, getName()
		if (names.getName().equals(name)) {
			System.out.println("\nPassed getName test 1");
		} else {
			System.out.println("\nFailed getName test 1");
		}

		// test 2, getName()
		name = "James";
		names = new NameRecord(name, base, rank);
		if (names.getName().equals(name)) {
			System.out.println("Passed getName test 2");
		} else {
			System.out.println("Failed getName test 2");
		}

		// test 3, getBaseDecade
		names = new NameRecord(name, base, rank);
		if (names.getBaseDecade() == base) {
			System.out.println("Passed getBaseDecade test 3");
		} else {
			System.out.println("Failed getBaseDecade test 3");
		}

		// test 4, getBaseDecade
		base = 2020;
		names = new NameRecord(name, base, rank);
		if (names.getBaseDecade() == base) {
			System.out.println("Passed getBaseDecade test 4");
		} else {
			System.out.println("Failed getBaseDecade test 4");
		}

		// test 5, getNumDecades()
		rank.add(243);
		rank.add(68);
		rank.add(12);
		rank.add(3);
		names = new NameRecord(name, base, rank);
		if (names.getNumDecades() == rank.size()) {
			System.out.println("Passed getNumDecades() test 5");
		} else {
			System.out.println("Failed getNumDecades() test 5");
		}

		// test 6, getNumDecades()
		rank.add(2);
		rank.add(1);
		names = new NameRecord(name, base, rank);
		if (names.getNumDecades() == rank.size()) {
			System.out.println("Passed getNumDecades() test 6");
		} else {
			System.out.println("Failed getNumDecades() test 6");
		}

		// test 7, getRank(num)
		names = new NameRecord(name, base, rank);
		int num = 2;
		if (names.getRank(num) == rank.get(num)) {
			System.out.println("Passed getRank(num) test 7");
		} else {
			System.out.println("Failed getRank(num) test 7");
		}

		// test 8, getRank(num)
		names = new NameRecord(name, base, rank);
		num = 4;
		if (names.getRank(num) == rank.get(num)) {
			System.out.println("Passed getRank(num) test 8");
		} else {
			System.out.println("Failed getRank(num) test 8");
		}

		// test 9, getBestDecade()
		names = new NameRecord(name, base, rank);
		num = 2070;
		if (names.getBestDecade() == num) {
			System.out.println("Passed getBestDecade() test 9");
		} else {
			System.out.println("Failed getBestDecade() test 9");
		}

		// test 10, getBestDecade()
		rank.remove(5);
		names = new NameRecord(name, base, rank);
		num = 2060;
		if (names.getBestDecade() == num) {
			System.out.println("Passed getBestDecade() test 10");
		} else {
			System.out.println("Failed getBestDecade() test 10");
		}

		// test 11, numTop1000()
		names = new NameRecord(name, base, rank);
		num = 5;
		if (names.numTop1000() == num) {
			System.out.println("Passed numTop1000() test 11");
		} else {
			System.out.println("Failed numTop1000() test 11");
		}

		// test 12, numTop1000()
		rank.add(1);
		rank.add(0);
		names = new NameRecord(name, base, rank);
		num = 6;
		if (names.numTop1000() == num) {
			System.out.println("Passed numTop1000() test 12");
		} else {
			System.out.println("Failed numTop1000() test 12");
		}

		// test 13, everyDecade()
		names = new NameRecord(name, base, rank);
		boolean isTop = false;
		if (names.everyDecade() == isTop) {
			System.out.println("Passed everyDecade() test 13");
		} else {
			System.out.println("Failed everyDecade() test 13");
		}

		// test 14, everyDecade()
		rank.remove(6);
		names = new NameRecord(name, base, rank);
		isTop = true;
		if (names.everyDecade() == isTop) {
			System.out.println("Passed everyDecade() test 14");
		} else {
			System.out.println("Failed everyDecade() test 14");
		}

		// test 15, oneDecade()
		names = new NameRecord(name, base, rank);
		isTop = false;
		if (names.oneDecade() == isTop) {
			System.out.println("Passed oneDecade() test 15");
		} else {
			System.out.println("Failed oneDecade() test 15");
		}

		// test 16, oneDecade()
		ArrayList<Integer> rank2 = new ArrayList<Integer>();
		rank2.add(0);
		rank2.add(0);
		rank2.add(0);
		rank2.add(234);
		names = new NameRecord(name, base, rank2);
		isTop = true;
		if (names.oneDecade() == isTop) {
			System.out.println("Passed oneDecade() test 16");
		} else {
			System.out.println("Failed oneDecade() test 16");
		}

		// test 17, morePopular()
		names = new NameRecord(name, base, rank);
		isTop = true;
		if (names.morePopular() == isTop) {
			System.out.println("Passed morePopular() test 17");
		} else {
			System.out.println("Failed morePopular() test 17");
		}

		// test 18, morePopular()
		names = new NameRecord(name, base, rank2);
		isTop = false;
		if (names.morePopular() == isTop) {
			System.out.println("Passed morePopular() test 18");
		} else {
			System.out.println("Failed morePopular() test 18");
		}

		// test 19, lessPopular()
		names = new NameRecord(name, base, rank);
		isTop = false;
		if (names.lessPopular() == isTop) {
			System.out.println("Passed lessPopular() test 19");
		} else {
			System.out.println("Failed lessPopular() test 19");
		}

		// test 20, lessPopular()
		rank2.add(433);
		rank2.add(867);
		rank2.add(986);
		names = new NameRecord(name, base, rank2);
		isTop = false;
		if (names.lessPopular() == isTop) {
			System.out.println("Passed lessPopular() test 20");
		} else {
			System.out.println("Failed lessPopular() test 20");
		}

		// test 21, toString()
		name = "Angel";
		names = new NameRecord(name, base, rank);
		String output = "Angel\n" + "2020: 243\n" + "2030: 68\n" + "2040: 12\n" + "2050: 3\n" + 
		"2060: 2\n"
				+ "2070: 1\n";
		if (names.toString().equals(output)) {
			System.out.println("Passed toString() test 21");
		} else {
			System.out.println("Failed toString() test 21");
		}

		// test 22, toString()
		name = "Samir";
		names = new NameRecord(name, base, rank2);
		output = "Samir\n" + "2020: 0\n" + "2030: 0\n" + "2040: 0\n" + "2050: 234\n" + "2060: 433\n" 
		+ "2070: 867\n"
				+ "2080: 986\n";
		if (names.toString().equals(output)) {
			System.out.println("Passed toString() test 22");
		} else {
			System.out.println("Failed toString() test 22");
		}

		// test 23, compareTo
		names = new NameRecord(name, base, rank);
		NameRecord other = new NameRecord("Kai", base, rank2);
		num = 1;
		if (names.compareTo(other) > 0 && num > 0) {
			System.out.println("Passed compareTo() test 23");
		} else {
			System.out.println("Failed compareTo() test 23");
		}

		// test 24, compareTo
		names = new NameRecord(name, base, rank);
		other = new NameRecord(name, base, rank);
		num = 0;
		if (names.compareTo(other) == num) {
			System.out.println("Passed compareTo() test 24");
		} else {
			System.out.println("Failed compareTo() test 24");
		}

	}

	// A few simple tests for the Names and NameRecord class.
	public static void simpleTest() {
		// raw data for Jake. Alter as necessary for your NameRecord
		String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
		int baseDecade = 1900;
		ArrayList<Integer> rank = new ArrayList<>();
		Scanner file = new Scanner(jakeRawData);
		String name = file.next();
		while (file.hasNext()) {
			rank.add(file.nextInt());
		}
		NameRecord jakeRecord = new NameRecord(name, baseDecade, rank);
		String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: "
				+ "484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: " + "117\n2000: 97\n";
		String actual = jakeRecord.toString();
		System.out.println("expected string:\n" + expected);
		System.out.println("actual string:\n" + actual);
		if (expected.equals(actual)) {
			System.out.println("passed Jake toString test.");
		} else {
			System.out.println("FAILED Jake toString test.");
		}

		// Some getName Tests

		Names names = new Names(getFileScannerForNames("names.txt"));
		String[] testNames = { "Isabelle", "isabelle", "sel", "X1178", "ZZ", "via", "kelly" };
		boolean[] expectNull = { false, false, true, true, true, true, false };
		for (int i = 0; i < testNames.length; i++) {
			performGetNameTest(names, testNames[i], expectNull[i]);
		}
	}

	// Checks if given name is present in Names.
	private static void performGetNameTest(Names names, String name, boolean expectNull) {

		System.out.println("Performing test for this name: " + name);
		if (expectNull) {
			System.out.println("Expected return value is null");
		} else {
			System.out.println("Expected return value is not null");
		}
		NameRecord result = names.getName(name);
		if ((expectNull && result == null) || (!expectNull && result != null)) {
			System.out.println("PASSED TEST.");
		} else {
			System.out.println("Failed test");
		}
	}

	// main method. Driver for the whole program
	public static void main(String[] args) {
		
		//myTests();
		// Alter name of file to try different data sources.
		final String NAME_FILE = "names.txt";
		Scanner fileScanner = getFileScannerForNames(NAME_FILE);
		Names namesDatabase = new Names(fileScanner);
		fileScanner.close();
		runOptions(namesDatabase);
	}

	/*
	 * pre: namesDatabase != null Ask user for options to perform on the given Names
	 * object. Creates a Scanner connected to System.in.
	 */
	private static void runOptions(Names namesDatabase) {
		Scanner keyboard = new Scanner(System.in);
		MenuChoices[] menuChoices = MenuChoices.values();
		MenuChoices menuChoice;
		do {
			showMenu();
			int userChoice = getChoice(keyboard) - 1;
			menuChoice = menuChoices[userChoice];
			if (menuChoice == MenuChoices.SEARCH) {
				search(namesDatabase, keyboard);
			} else if (menuChoice == MenuChoices.ONE_NAME) {
				oneName(namesDatabase, keyboard);
			} else if (menuChoice == MenuChoices.APPEAR_ONCE) {
				appearOnce(namesDatabase);
			} else if (menuChoice == MenuChoices.APPEAR_ALWAYS) {
				appearAlways(namesDatabase);
			} else if (menuChoice == MenuChoices.ALWAYS_MORE) {
				alwaysMore(namesDatabase);
			} else if (menuChoice == MenuChoices.ALWAYS_LESS) {
				alwaysLess(namesDatabase);
			} else if (menuChoice == MenuChoices.STUDENT_SEARCH) {
				// CS314 students, call your search method here
				uniqueNames(namesDatabase, keyboard);
			}
		} while (menuChoice != MenuChoices.QUIT);
		keyboard.close();
	}

	/*
	 * Create a Scanner and return connected to a File with the given name. pre:
	 * fileName != null post: Return a Scanner connected to the file or null if the
	 * File does not exist in the current directory.
	 */
	private static Scanner getFileScannerForNames(String fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("\n***** ERROR IN READING FILE ***** ");
			System.out.println("Can't find this file " + fileName + " in the current directory.");
			System.out.println("Error: " + e);
			String currentDir = System.getProperty("user.dir");
			System.out.println("Be sure " + fileName + " is in this directory: ");
			System.out.println(currentDir);
			System.out.println("\nReturning null from method.");
			sc = null;
		}
		return sc;
	}

	/*
	 * Display the names that have appeared in every decade. pre: n != null post:
	 * print out names that have appeared in ever decade
	 */
	private static void appearAlways(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
		}
		System.out.println(namesDatabase.rankedEveryDecade().size() +
				" names appear in every decade. The names are:");
		for (int i = 0; i < namesDatabase.rankedEveryDecade().size(); i++) {
			System.out.println(namesDatabase.rankedEveryDecade().get(i));
		}

	}

	/*
	 * Display the names that have appeared in only one decade. pre: n != null post:
	 * print out names that have appeared in only one decade
	 */
	private static void appearOnce(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot be null");
		}
		System.out.println(
				namesDatabase.rankedOnlyOneDecade().size() + 
				" names appear in exactly one decade. The names are:");
		for (int i = 0; i < namesDatabase.rankedOnlyOneDecade().size(); i++) {
			System.out.println(namesDatabase.rankedOnlyOneDecade().get(i));
		}
	}

	/*
	 * Display the names that have gotten more popular in each successive decade.
	 * pre: n != null post: print out names that have gotten more popular in each
	 * decade
	 */
	private static void alwaysMore(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot be null");
		}
		System.out.println(namesDatabase.alwaysMorePopular().size() + 
				" names are more popular in every decade");
		for (int i = 0; i < namesDatabase.alwaysMorePopular().size(); i++) {
			System.out.println(namesDatabase.alwaysMorePopular().get(i));
		}
	}

	/*
	 * Display the names that have gotten less popular in each successive decade.
	 * pre: n != null post: print out names that have gotten less popular in each
	 * decade
	 */
	private static void alwaysLess(Names namesDatabase) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot be null");
		}
		System.out.println(namesDatabase.alwaysLessPopular().size() +
				" names are less popular in every decade. ");
		for (int i = 0; i < namesDatabase.alwaysLessPopular().size(); i++) {
			System.out.println(namesDatabase.alwaysLessPopular().get(i));
		}
	}

	/*
	 * Display the data for one name or state that name has never been ranked. pre:
	 * n != null, keyboard != null and is connected to System.in post: print out the
	 * data for n or a message that n has never been in the top 1000 for any decade
	 */
	private static void oneName(Names namesDatabase, Scanner keyboard) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (namesDatabase == null || keyboard == null) {
			throw new IllegalArgumentException("The parameters cannot be null");
		}
		System.out.print("Enter a name: ");
		String name = keyboard.next();
		System.out.println("\n" + namesDatabase.getName(name).toString());

	}

	/*
	 * Display all names that contain a substring from the user and the decade they
	 * were most popular. pre: n != null, keyboard != null and is connected to
	 * System.in post: display the data for each name.
	 */
	private static void search(Names namesDatabase, Scanner keyboard) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (namesDatabase == null || keyboard == null) {
			throw new IllegalArgumentException("The parameters cannot be null");
		}
		System.out.print("Enter a partial name: ");
		String name = keyboard.next();
		ArrayList<NameRecord> match = namesDatabase.getMatches(name);
		if (match.size() != 0) {
			System.out.println("There are " + match.size() + " matches for " + name + ".\n");
			for (int i = 0; i < match.size(); i++) {
				System.out.println(match.get(i).getName() + " " + match.get(i).getBestDecade());
			}
		} else {
			System.out.println("\n" + "There are 0 matches for" + name);
		}
	}

	// displays names based on the max rank and the decade for the rank that the
	// name shows up in
	// these depend on the users input so the uniqueness of the names depends on the
	// user
	// pre = namesDatabase != null
	private static void uniqueNames(Names namesDatabase, Scanner keyboard) {
		if (namesDatabase == null) {
			throw new IllegalArgumentException("The parameter" + " namesDatabase cannot be null");
		}
		System.out.print("Enter a max rank out of 1000: ");
		int maxrank = keyboard.nextInt();
		System.out.print("Enter a decade for max rank: ");
		int dec = keyboard.nextInt();
		if (namesDatabase.unique(maxrank, dec).size() != 0) {
			for (int i = 0; i < namesDatabase.unique(maxrank, dec).size(); i++) {
				System.out.println(namesDatabase.unique(maxrank, dec).get(i));
			}
		} else {
			System.out.println("\n" + "There are 0 unique names");
		}
	}

	/*
	 * Get choice from the user keyboard != null and is connected to System.in
	 * return an int that is >= MenuChoices.SEARCH.ordinal() and <=
	 * MenuChoices.QUIT.ordinal().
	 */
	private static int getChoice(Scanner keyboard) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (keyboard == null) {
			throw new IllegalArgumentException("The parameter keyboard cannot be null");
		}
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		// Add one due to zero based indexing of enums, but 1 based indexing of menu.
		final int MAX_CHOICE = MenuChoices.QUIT.ordinal() + 1;
		while (choice < 1 || choice > MAX_CHOICE) {
			System.out.println();
			System.out.println(choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}

	/*
	 * Ensure an int is entered from the keyboard. pre: s != null and is connected
	 * to System.in post: return the int typed in by the user.
	 */
	private static int getInt(Scanner s, String prompt) {
		// Note, no way to check if keyboard actually connected to System.in
		// so we simply assume it is.
		if (s == null) {
			throw new IllegalArgumentException("The parameter s cannot be null");
		}
		System.out.print(prompt);
		while (!s.hasNextInt()) {
			s.next();
			System.out.println("That was not an int.");
			System.out.print(prompt);
		}
		return s.nextInt();
	}

	// Show the user the menu.
	private static void showMenu() {
		System.out.println();
		System.out.println("Options:");
		System.out.println("Enter 1 to search for names.");
		System.out.println("Enter 2 to display data for one name.");
		System.out.println("Enter 3 to display all names that appear in only " + "one decade.");
		System.out.println("Enter 4 to display all names that appear in all " + "decades.");
		System.out.println("Enter 5 to display all names that are more popular " + "in every decade.");
		System.out.println("Enter 6 to display all names that are less popular " + "in every decade.");
		System.out.println("Enter 7 to display all names that are unique.");
		System.out.println("Enter 8 to quit.");
		System.out.println();
	}

	/**
	 * An enumerated type to hold the menu choices for the NameSurfer program.
	 */
	private static enum MenuChoices {
		SEARCH, ONE_NAME, APPEAR_ONCE, APPEAR_ALWAYS, ALWAYS_MORE, ALWAYS_LESS, STUDENT_SEARCH, QUIT;
	}
}