package designpatterns.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		System.out.println("Creating book parser");
		IBookParser bp = new ProxyBookParser("hello, how are you?");
		System.out.println("getting number of pages");
		bp.getNumPages();
	}

}
