package designpatterns.abstractfactory;

public class MacFactory implements OSFactory {

	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public TerminalWindow createTerminalWindow() {
		return new MacTerminalWindow();
	}

}
