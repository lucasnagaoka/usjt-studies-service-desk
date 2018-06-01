package observer;

import java.util.Observable;

public abstract class Noticiario extends Observable {
	public abstract void notificaNoticia(String textoNoticia, int dia, int mes, String topico);

}
