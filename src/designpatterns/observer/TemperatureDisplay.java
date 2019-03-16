package designpatterns.observer;

public class TemperatureDisplay implements IObserver {

	@Override
	public void update(IObservable observable) {
		int temp = ((WeatherStation)observable).getTemperature();
		System.out.println("Temperature is:"+temp);
	}

}
