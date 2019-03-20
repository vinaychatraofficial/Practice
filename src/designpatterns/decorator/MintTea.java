package designpatterns.decorator;

public class MintTea extends AddOnDecorator {
	
	public MintTea(Beverage b) {
		this.b=b;
	}

	@Override
	public int cost() {
		return this.b.cost()+3;
	}

}
