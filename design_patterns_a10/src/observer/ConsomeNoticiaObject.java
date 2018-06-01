package observer;

import java.util.List;

public class ConsomeNoticiaObject implements Subject, ConsomeNoticia {
	private final List<Observer> observers;
	private String noticia;
	private final String subjectDetails;

	public ConsomeNoticiaObject(List<Observer> observers, String subjectDetails) {
		this.observers = observers;
		this.subjectDetails = subjectDetails;
	}

	@Override
	public void notificaNoticia(String textoNoticia, int dia, int mes, String topico) {
		this.noticia = textoNoticia;
		notifyObservers();

	}

	@Override
	public void subscribeObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void unSubscribeObserver(Observer observer) {
		int index = observers.indexOf(observer);
		observers.remove(index);

	}

	@Override
	public void notifyObservers() {
		System.out.println();
		for (Observer observer : observers) {
			observer.update(noticia);
		}

	}

	@Override
	public String subjectDetails() {
		return subjectDetails;
	}
}
