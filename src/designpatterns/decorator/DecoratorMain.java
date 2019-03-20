package designpatterns.decorator;

public class DecoratorMain {

	public static void main(String[] args) {
		Beverage tea = new Tea();
		Beverage mintTea = new MintTea(tea);
		Beverage darjeelingMintTea = new Darjeeling(mintTea);
		System.out.println(darjeelingMintTea.cost());
	}

}
