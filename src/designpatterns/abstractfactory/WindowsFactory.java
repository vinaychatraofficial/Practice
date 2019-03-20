package designpatterns.abstractfactory;

public class WindowsFactory implements OSFactory {

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public TerminalWindow createTerminalWindow() {
		return new WindowsTerminalWindow();
	}

}
