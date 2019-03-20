package designpatterns.decorator;

public class DecoratorMain {

	public static void main(String[] args) {
		Drink milk = new Milk();
		Drink water = new Water();
		Drink blackTea = new Tea(water);
		Drink mintTea = new MintTea(blackTea);
		Drink tea = new Tea(milk);
		Drink coffee = new Coffee(milk);
		System.out.println(mintTea.cost());
	}

}
