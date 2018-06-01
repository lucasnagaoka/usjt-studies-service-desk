package templatemethod.comparator;

import java.util.Arrays;

public class Main {
	private static final int NUM = 10;

	private static Double[] construirVetor() {
		Double[] d = new Double[NUM];
		for (int i = 0; i < d.length; i++)
			d[i] = Math.random() * NUM;
		return d;
	}

	public static void main(String[] args) throws Exception {
		Double[] v = construirVetor();

		Arrays.sort(v, new DoubleComparator());

		System.out.println(Arrays.toString(v));
	}
}
