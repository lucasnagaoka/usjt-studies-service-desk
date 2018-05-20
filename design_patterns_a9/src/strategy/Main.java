package strategy;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class Main {
	private static final int NUM = 100000;

	private static double[] buildArray() {
		double[] d = new double[NUM];
		for (int i = 0; i < d.length; i++)
			d[i] = Math.random() * NUM;
		return d;
	}

	public static void main(String[] args) throws Exception {
		long antes, tempo;
		SortStrategy sort;
		double[] bubbleV, mergeV, quickV, insertionV;

		System.out.print("Criando vetores. ");
		bubbleV = buildArray();
		mergeV = bubbleV.clone();
		quickV = bubbleV.clone();
		insertionV = bubbleV.clone();
		System.out.println("Ok!\n");

		sort = new BubbleSort();
		antes = System.currentTimeMillis();
		sort.sort(bubbleV);
		tempo = System.currentTimeMillis() - antes;
		System.out.println("Bubble Sort: " + tempo + " ms.");

		sort = new InsertionSort();
		antes = System.currentTimeMillis();
		sort.sort(insertionV);
		tempo = System.currentTimeMillis() - antes;
		System.out.println("Insertion Sort: " + tempo + " ms.");

		sort = new MergeSort();
		antes = System.currentTimeMillis();
		sort.sort(mergeV);
		tempo = System.currentTimeMillis() - antes;
		System.out.println("Merge Sort: " + tempo + " ms.");

		sort = new QuickSort();
		antes = System.currentTimeMillis();
		sort.sort(quickV);
		tempo = System.currentTimeMillis() - antes;
		System.out.println("Quick Sort: " + tempo + " ms.");
	}
}
