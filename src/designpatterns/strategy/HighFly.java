package designpatterns.strategy;

public class HighFly implements IFlyBehavior {

	@Override
	public void fly() {
		System.out.println("flies high");
	}

}
