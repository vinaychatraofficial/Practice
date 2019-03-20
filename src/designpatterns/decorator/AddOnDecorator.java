package designpatterns.decorator;

public abstract class AddOnDecorator implements Drink {
	Drink b;
	
	public AddOnDecorator(Drink b) {
		this.b=b;
	}
	
	public abstract int cost();
	
}
