package designpatterns.observer;

public class ObserverMain {

	public static void main(String[] args) {
		IObservable station = new WeatherStation();
		IObserver display = new TemperatureDisplay();
		station.register(display);
		station.notifyObserver();
		station.notifyObserver();
	}

}
