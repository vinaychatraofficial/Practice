package designpatterns.factorymethod;

public class RandomFactory implements AnimalFactory {

	public Animal createAnimal() {
		int random = 1 + (int)(Math.random() * 3);
		System.out.println(random);
		switch(random) {
		case 1: return new Cat();
		case 2: return new Dog();
		case 3: return new Hen();
		}
		return null;
		
	}

}
