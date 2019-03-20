package designpatterns.decorator;

public class Tea extends AddOnDecorator {

	public Tea(Drink b) {
		super(b);
	}

	@Override
	public int cost() {
		return this.b.cost()+2;
	}

}
