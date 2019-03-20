package designpatterns.abstractfactory;

public class MacButton implements Button {

	@Override
	public void getDescription() {
		System.out.println("This is a mac button");
	}

}
