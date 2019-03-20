package designpatterns.strategy;

public class MountainDuck extends Duck {
	

	
	public MountainDuck(IFlyBehavior flyBehavior, IQuackBehavior quackBehavior) {
		super(flyBehavior, quackBehavior);
	}

	@Override
	void description() {
		System.out.println("This is a mountain duck");
		
	}

}
