package designpatterns.strategy;

public class LoudQuack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("loudly quacking");
	}

}
