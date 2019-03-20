package designpatterns.abstractfactory;

public class MacTerminalWindow implements TerminalWindow {

	@Override
	public void getDescription() {
		System.out.println("This is a mac terminal window");
	}

}
