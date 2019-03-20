package designpatterns.decorator;

public abstract class AddOnDecorator implements Beverage {
	Beverage b;
	public abstract int cost();
	
}
