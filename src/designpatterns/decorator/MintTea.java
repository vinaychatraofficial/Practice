package designpatterns.decorator;

public class MintTea extends AddOnDecorator {
	
	

	public MintTea(Drink b) {
		super(b);
	}

	@Override
	public int cost() {
		return this.b.cost()+1;
	}

}
