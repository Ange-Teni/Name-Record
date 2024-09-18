import java.util.ArrayList;
/*  Student information for assignment:
*
*  On my honor, <Angel>, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID:aoo795
*  email address:angel-ogungbemi@utexas.edu
*  Number of slip days I am using:1
*/
public class NameRecord implements Comparable<NameRecord> {
	private String name;
	private int baseDecade;
	private ArrayList<Integer> rank;

	public NameRecord(String name, int baseDecade, ArrayList<Integer> rank) {
		if (name == null || rank == null) {
			throw new IllegalArgumentException("parameters cannot be null ");
		}
		this.name = name;
		this.baseDecade = baseDecade;
		this.rank = rank;
	}

	// getter method for name
	public String getName() {
		return name;
	}

	// getter method for base decade
	public int getBaseDecade() {
		return baseDecade;
	}

	// getter method for number of decades
	public int getNumDecades() {
		return rank.size();
	}

	// getter method for rank
	// pre = parameter num has to be in bounds
	public int getRank(int num) {
		if (num >= rank.size()) {
			throw new IllegalArgumentException("The parameter is out of bounds");
		}
		return rank.get(num);
	}

	// getter method for the best rank
	public int getBestDecade() {
		int bestDec = baseDecade;
		int rankbest = rank.get(0);
		for (int i = 1; i < rank.size(); i++) {
			if (rankbest == 0) {
				rankbest = 1001;
			}
			if (rank.get(i) < rankbest && rank.get(i) != 0) {
				rankbest = rank.get(i);
				bestDec = (baseDecade + (i * 10));
			}
		}
		return bestDec;
	}

	// getter method for number of ranks in top 1000
	public int numTop1000() {
		int count = 0;
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) > 0) {
				count++;
			}
		}
		return count;
	}

	// returns true if name ranks in every decade
	public boolean everyDecade() {
		int count = 0;
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) > 0) {
				count++;
			}
		}
		if (count == rank.size()) {
			return true;
		}
		return false;
	}

	// returns true if ranks in one decade only
	public boolean oneDecade() {
		int count = 0;
		for (int i = 0; i < rank.size(); i++) {
			if (rank.get(i) > 0) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

	// returns true if name gets more popular every decade
	public boolean morePopular() {
		for (int i = 1; i < rank.size(); i++) {
			if (rank.get(i) > rank.get(i - 1) || rank.get(i) == 0 || rank.get(i - 1) == 0) {
				return false;
			}
		}
		return true;
	}

	// returns true if name gets less popular every decade
	public boolean lessPopular() {
		for (int i = 1; i < rank.size(); i++) {
			if (rank.get(i) <= rank.get(i - 1) && rank.get(i) != 0 || rank.get(i - 1) == 0) {
				return false;
			}

		}
		return true;
	}

	// override toString
	public String toString() {
		StringBuilder display = new StringBuilder();
		display.append("" + name);
		for (int i = 0; i < rank.size(); i++) {
			display.append("\n" + (baseDecade + (i * 10)) + ": " + rank.get(i));
		}
		display.append("\n");
		return display.toString();
	}

	// compareTo
	public int compareTo(NameRecord other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}

}
