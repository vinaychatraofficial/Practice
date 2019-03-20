package designpatterns.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2= Singleton.getInstance();
		EnumSingleton obj3 = EnumSingleton.INSTANCE;
		EnumSingleton obj4=  EnumSingleton.INSTANCE;
	}

}
