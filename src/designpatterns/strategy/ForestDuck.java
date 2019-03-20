package designpatterns.strategy;

public class ForestDuck extends Duck {
	
	

	public ForestDuck(IFlyBehavior flyBehavior, IQuackBehavior quackBehavior) {
		super(flyBehavior, quackBehavior);
	}

	@Override
	void description() {
		System.out.println("this is a forest duck");
	}

}
