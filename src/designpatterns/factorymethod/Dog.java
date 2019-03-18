package designpatterns.factorymethod;

public class Dog implements Animal {

	@Override
	public void getDescription() {
		System.out.println("This is a dog");
	}

}
