package designpatterns.factorymethod;

public class FactoryMethodMain {

	public static void main(String[] args) {
		AnimalFactory factory = new RandomFactory();
		Animal animal = factory.createAnimal();
		animal.getDescription();
	}

}
