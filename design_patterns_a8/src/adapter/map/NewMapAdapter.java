package adapter.map;

import java.util.HashMap;

public class NewMapAdapter extends HashMap<Object, Object> {

	private static final long serialVersionUID = 1L;

	public NewMapAdapter(Object[][] pares) {

		Object[] chaves = pares[0];
		Object[] colunas = pares[1];

		for (int i = 0; i < chaves.length; i++) {
			put(chaves[i], colunas[i]);
		}
	}
}
