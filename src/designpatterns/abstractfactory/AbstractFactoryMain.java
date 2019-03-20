package designpatterns.abstractfactory;

public class AbstractFactoryMain {

	public static void main(String[] args) {
		OSFactory factory = new WindowsFactory();
		Button button = factory.createButton();
		button.getDescription();
		TerminalWindow window = factory.createTerminalWindow();
		window.getDescription();
	}

}
