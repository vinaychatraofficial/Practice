package designpatterns.adapter;

public class UKAdapter implements IAdapter {
	
	UKPlugpoint plugPoint;
	
	public UKAdapter(UKPlugpoint plugPoint) {
		this.plugPoint = plugPoint;
	}

	@Override
	public void insertAdapter() {
		plugPoint.insertPlug();

	}

}
