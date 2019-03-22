package designpatterns.proxy;

public class RealBookParser implements IBookParser {
	int pages;
	
	public RealBookParser(String book) {
		//computationally intensive operation
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.pages = book.length()/10;
		System.out.println("pages is "+this.pages);
	}

	@Override
	public int getNumPages() {
		return pages;
	}

}
