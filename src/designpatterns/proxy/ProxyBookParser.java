package designpatterns.proxy;

public class ProxyBookParser implements IBookParser {
	
	String book;
	RealBookParser rbp;
	
	public ProxyBookParser(String book) {
		this.book = book;
	}

	@Override
	public int getNumPages() {
		if(rbp==null)
			rbp = new RealBookParser(this.book);
		return rbp.getNumPages();
	}

}
