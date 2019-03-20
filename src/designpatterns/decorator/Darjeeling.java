package designpatterns.decorator;

public class Darjeeling extends AddOnDecorator {
	
	public Darjeeling(Beverage b) {
		this.b=b;
	}

	@Override
	public int cost() {
		return this.b.cost()+4;
	}

}
