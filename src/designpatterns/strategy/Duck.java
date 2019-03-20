package designpatterns.strategy;

public abstract class Duck {
	
	IFlyBehavior flyBehavior;
	IQuackBehavior quackBehavior;
	
	
	
	public Duck(IFlyBehavior flyBehavior, IQuackBehavior quackBehavior) {
		super();
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior;
	}

	void fly() {
		flyBehavior.fly();
	}
	
	void quack() {
		quackBehavior.quack();
	}
	
	abstract void description();

}
