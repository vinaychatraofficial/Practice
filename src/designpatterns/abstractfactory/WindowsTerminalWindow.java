package designpatterns.abstractfactory;

public class WindowsTerminalWindow implements TerminalWindow {

	@Override
	public void getDescription() {
		System.out.println("This is a windows terminal window");
	}

}
