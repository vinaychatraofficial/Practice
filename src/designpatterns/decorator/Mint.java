package designpatterns.decorator;

public class Mint extends AddOnDecorator {
	
	

	public Mint(Drink b) {
		super(b);
	}

	@Override
	public int cost() {
		return this.b.cost()+1;
	}

}
