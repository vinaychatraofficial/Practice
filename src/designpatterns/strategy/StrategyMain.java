package designpatterns.strategy;

public class StrategyMain {

	public static void main(String[] args) {
		IFlyBehavior fly = new HighFly();
		IQuackBehavior quack = new LoudQuack();
		Duck d = new MountainDuck(fly, quack);
		d.description();
		d.fly();
		d.quack();
		fly = new LowFly();
		quack = new SilentQuack();
		d = new ForestDuck(fly, quack);
		d.description();
		d.fly();
		d.quack();
	}

}
