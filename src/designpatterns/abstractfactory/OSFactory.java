package designpatterns.abstractfactory;

public interface OSFactory {
	
	Button createButton();
	
	TerminalWindow createTerminalWindow();

}
