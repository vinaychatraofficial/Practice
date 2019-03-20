package designpatterns.abstractfactory;

public class WindowsButton implements Button {

	@Override
	public void getDescription() {
		System.out.println("This is a windows button");
		
	}

}
