package designpatterns.decorator;

public class Coffee extends AddOnDecorator {

	public Coffee(Drink b) {
		super(b);
	}

	@Override
	public int cost() {
		return this.b.cost()+2;
	}

}
