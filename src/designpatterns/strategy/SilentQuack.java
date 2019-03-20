package designpatterns.strategy;

public class SilentQuack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("silently quacking");
	}

}
