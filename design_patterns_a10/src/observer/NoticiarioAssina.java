package observer;

import java.util.Observable;
import java.util.Observer;

public class NoticiarioAssina extends Noticiario implements Observer {

	@Override
	public void notificaNoticia(String textoNoticia, int dia, int mes, String topico) {
		System.out.println("Notícia: " + textoNoticia);
		update(this, textoNoticia);
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}

}
