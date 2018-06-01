package templatemethod.comparator;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
	public int compare(Double d1, Double d2) {
		Double newD1 = d1 - Math.floor(d1);
		Double newD2 = d2 - Math.floor(d2);
		return newD1.compareTo(newD2);
	}
}
