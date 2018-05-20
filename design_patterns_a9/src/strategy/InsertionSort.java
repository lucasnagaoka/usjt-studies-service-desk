package strategy;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class InsertionSort implements SortStrategy {
	
	public void sort(double[] x) {
		insertionSort(x);
	}

	public void insertionSort(double[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (a[j] < a[j - 1])
					exch(a, j, j - 1);
				else break;
	}

	private void exch(double[] a, int i, int j) {
		double swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
