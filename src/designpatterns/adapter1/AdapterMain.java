package designpatterns.adapter1;

public class AdapterMain {

	public static void main(String[] args) {
		Animal cat = new Cat();
		cat.makeNoise();
		Animal dog = new Dog();
		dog.makeNoise();
		Bird hen = new Hen();
		Animal bird = new BirdAdapter(hen);
		bird.makeNoise();
	}

}
