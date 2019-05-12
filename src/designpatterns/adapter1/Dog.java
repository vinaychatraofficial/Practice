package designpatterns.adapter1;

public class Dog implements Animal {

	@Override
	public void makeNoise() {
		System.out.println("bow");
	}

}
