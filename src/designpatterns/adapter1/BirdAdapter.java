package designpatterns.adapter1;

public class BirdAdapter implements Animal {
	Bird b;
	
	public BirdAdapter(Bird b) {
		this.b=b;
	}

	@Override
	public void makeNoise() {
		b.quack();
	}

}
