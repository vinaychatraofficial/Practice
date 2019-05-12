package designpatterns.decorator;

public class TeaLeaves extends AddOnDecorator {

	public TeaLeaves(Drink b) {
		super(b);
	}

	@Override
	public int cost() {
		return this.b.cost()+2;
	}

}
