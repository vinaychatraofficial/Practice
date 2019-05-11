package designpatterns.factorymethod;

import java.util.Calendar;

public class TimeFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		day = day%3;
		switch(day) {
		case 0:return new Cat();
		case 1: return new Dog();
		case 2: return new Hen();
		}
		return null;
	}

}
