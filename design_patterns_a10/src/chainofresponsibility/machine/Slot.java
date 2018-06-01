package chainofresponsibility.machine;

public class Slot {
	private int valorAceito;
	private Slot proximo;
	private int valorTotal = 0;

	public Slot(int valorAceito) {
		this.valorAceito = valorAceito;
	}

	public Slot(int valorAceito, Slot proximo) {
		this(valorAceito);
		this.proximo = proximo;
	}

	public void receber(Moeda moeda) {
		if (moeda.getValor() == valorAceito) {
			valorTotal += valorAceito;
		} else if (proximo != null) {
			proximo.receber(moeda);
		}
	}

	public int obterValorTotal() {
		return valorTotal + ((proximo == null) ? 0 : proximo.obterValorTotal());
	}
}
