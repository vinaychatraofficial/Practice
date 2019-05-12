package designpatterns.decorator;

public class DecoratorMain {

	public static void main(String[] args) {
		Drink milk = new Milk();
		Drink water = new Water();
		Drink blackTea = new TeaLeaves(water);
		Drink mintTea = new Mint(blackTea);
		Drink tea = new TeaLeaves(milk);
		Drink coffee = new CoffeeBeans(milk);
		System.out.println(mintTea.cost());
	}

}
