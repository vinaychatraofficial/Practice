package designpatterns.singleton;

public class Singleton {
	private static Singleton instance;
	
	private Singleton() {
		System.out.println("Inside constructor");
	}
	
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized(Singleton.class) {
				if(instance==null)
					instance = new Singleton();
			}
		}
		return instance;
	}
	

}
