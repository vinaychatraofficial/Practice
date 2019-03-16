package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IObservable {
	
	public List<IObserver> observers = new ArrayList<>();
	private int temperature;

	@Override
	public void register(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		temperature++;
		for(IObserver observer:observers) {
			observer.update(this);
		}
	}
	
	public int getTemperature() {
		return temperature;
	}

}
