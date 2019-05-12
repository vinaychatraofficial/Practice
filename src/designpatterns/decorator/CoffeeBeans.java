package designpatterns.decorator;

public class CoffeeBeans extends AddOnDecorator {

	public CoffeeBeans(Drink b) {
		super(b);
	}

	@Override
	public int cost() {
		return this.b.cost()+2;
	}

}
