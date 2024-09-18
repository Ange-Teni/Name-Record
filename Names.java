/*  Student information for assignment:
*
*  On my honor, <Angel>, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID:aoo795
*  email address:angel-ogungbemi@utexas.edu
*  Number of slip days I am using:1
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A collection of NameRecords. Stores NameRecord objects and provides methods
 * to select NameRecords based on various criteria.
 */
public class Names {

	private ArrayList<NameRecord> names;

	/**
	 * Construct a new Names object based on the data source the Scanner sc is
	 * connected to. Assume the first two lines in the data source are the base year
	 * and number of decades to use. Any lines without the correct number of decades
	 * are discarded and are not part of the resulting Names object. Any names with
	 * ranks of all 0 are discarded and not part of the resulting Names object.
	 * 
	 * @param sc Is connected to a data file with baby names and positioned at the
	 *           start of the data source.
	 */
	// pre = sc != null
	public Names(Scanner sc) {
		if (sc == null) {
			throw new IllegalArgumentException("parameters cannot be null ");
		}
		names = new ArrayList<NameRecord>();
		int base;
		String name;
		int decades;
		base = sc.nextInt();
		decades = sc.nextInt();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			Scanner lines = new Scanner(line);
			if (lines.hasNext()) {
				name = lines.next();
				ArrayList<Integer> rank = new ArrayList<>();
				while (lines.hasNext()) {
					rank.add(lines.nextInt());
				}
				if (rank.size() == decades) {
					names.add(new NameRecord(name, base, rank));
				}
				lines.close();
			}
		}
		sc.close();
		Collections.sort(names);

	}

	/**
	 * Returns an ArrayList of NameRecord objects that contain a given substring,
	 * ignoring case. The names must be in sorted order based on the names of the
	 * NameRecords.
	 * 
	 * @param partialName != null, partialName.length() > 0
	 * @return an ArrayList of NameRecords whose names contains partialName. If
	 *         there are no NameRecords that meet this criteria returns an empty
	 *         list.
	 */
	public ArrayList<NameRecord> getMatches(String partialName) {
		ArrayList<NameRecord> matches = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).getName().toUpperCase().contains(partialName.toUpperCase())) {
				matches.add(names.get(i));
			}
		}
		return matches;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been ranked in the top
	 * 1000 or better for every decade. The Strings must be in sorted order based on
	 * the name of the NameRecords.
	 * 
	 * @return A list of the names that have been ranked in the top 1000 or better
	 *         in every decade. The list is in sorted ascending order. If there are
	 *         no NameRecords that meet this criteria returns an empty list.
	 */
	public ArrayList<String> rankedEveryDecade() {
		ArrayList<String> ranked = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).everyDecade() == true) {
				ranked.add(names.get(i).getName() + "");
			}
		}
		return ranked;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been ranked in the top
	 * 1000 or better in exactly one decade. The Strings must be in sorted order
	 * based on the name of the NameRecords.
	 * 
	 * @return A list of the names that have been ranked in the top 1000 or better
	 *         in exactly one decade. The list is in sorted ascending order. If
	 *         there are no NameRecords that meet this criteria returns an empty
	 *         list.
	 */
	public ArrayList<String> rankedOnlyOneDecade() {
		ArrayList<String> ranked = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).oneDecade() == true) {
				ranked.add(names.get(i).getName() + "");
			}
		}
		return ranked;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been getting more popular
	 * every decade. The Strings must be in sorted order based on the name of the
	 * NameRecords.
	 * 
	 * @return A list of the names that have been getting more popular in every
	 *         decade. The list is in sorted ascending order. If there are no
	 *         NameRecords that meet this criteria returns an empty list.
	 */
	public ArrayList<String> alwaysMorePopular() {
		ArrayList<String> popular = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).morePopular() == true) {
				popular.add(names.get(i).getName() + "");
			}
		}
		return popular;
	}

	/**
	 * Returns an ArrayList of Strings of names that have been getting less popular
	 * every decade. The Strings must be in sorted order based on the name of the
	 * NameRecords.
	 * 
	 * @return A list of the names that have been getting less popular in every
	 *         decade. The list is in sorted ascending order. If there are no
	 *         NameRecords that meet this criteria returns an empty list.
	 */
	public ArrayList<String> alwaysLessPopular() {
		ArrayList<String> popular = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).lessPopular() == true) {
				popular.add(names.get(i).getName() + "");
			}
		}
		return popular;
	}

	/**
	 * Return the NameRecord in this Names object that matches the given String
	 * ignoring case. <br>
	 * <tt>pre: name != null</tt>
	 * 
	 * @param name The name to search for.
	 * @return The name record with the given name or null if no NameRecord in this
	 *         Names object contains the given name.
	 */
	public NameRecord getName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("The parameter name cannot be null");
		}
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).getName().equalsIgnoreCase(name)) {
				return names.get(i);
			}
		}
		return null;
	}

	// returns names based on the max rank and
	// number of decades the name shows up in
	// these depend on the users input so the uniqueness of the names depends on the
	// user
	// pre = decade for the name cannot be
	public ArrayList<String> unique(int maxRank, int decade) {
		ArrayList<String> unique = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (decade == names.get(i).getNumDecades()) {
				throw new IllegalArgumentException("decade or max decade out of bounds, enter "
						+ "number between 0 and " + names.get(i).getNumDecades());
			}
			if (maxRank < names.get(i).getRank(decade)) {
				unique.add(names.get(i).getName());
			}
		}
		return unique;
	}
}