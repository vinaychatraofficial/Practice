package designpatterns.observer;

import java.util.List;

public interface IObservable {
	
	public void register(IObserver observer);
	
	public void unregister(IObserver observer);
	
	public void notifyObserver();

}
