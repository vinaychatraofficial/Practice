package designpatterns.strategy;

public class LowFly implements IFlyBehavior {

	@Override
	public void fly() {
		System.out.println("flying low");
	}

}
