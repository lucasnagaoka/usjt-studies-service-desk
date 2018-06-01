package chainofresponsibility.machine;

public class Main {

	public static void main(String[] args) {
		Moeda[] moedas = new Moeda[] { new Moeda(25), new Moeda(10), new Moeda(50), new Moeda(5), new Moeda(100),
				new Moeda(10), new Moeda(10), new Moeda(50), new Moeda(25), new Moeda(25), new Moeda(100) };

		Slot cadeia = new Slot(1, new Slot(5, new Slot(10, new Slot(25, new Slot(50, new Slot(100))))));

		for (int i = 0; cadeia.obterValorTotal() < 100; i++) {
			System.out.println("Colocou moeda de " + moedas[i].getValor() + " centavos...");
			cadeia.receber(moedas[i]);
		}

		int troco = cadeia.obterValorTotal() - 100;
		System.out.println("Recebeu um refrigerante ($ 1,00). Seu troco: " + troco + " centavos.");
		System.out.println();

		cadeia = new Slot(1, new Slot(5, new Slot(10, new Slot(25, new Slot(50, new Slot(100))))));

		for (int i = 0; cadeia.obterValorTotal() < 250; i++) {
			System.out.println("Colocou moeda de " + moedas[i].getValor() + " centavos...");
			cadeia.receber(moedas[i]);
		}

		troco = cadeia.obterValorTotal() - 250;
		System.out.println("Recebeu um chips ($ 2,50). Seu troco: " + troco + " centavos.");
	}
}
