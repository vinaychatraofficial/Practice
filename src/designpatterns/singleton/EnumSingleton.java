package designpatterns.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	private EnumSingleton() {
		System.out.println("Inside enum singleton");
	}
}
