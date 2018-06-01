package strategy;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class BubbleSort implements SortStrategy {

	public void sort(double[] x) {
		bubbleSort(x, x.length);
	}

	public void bubbleSort(double[] a, int n) {
		for (int i = n - 1; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					double temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
