package designpatterns.adapter;

public class USAdapter implements IAdapter {
	
	USPlugpoint plugPoint;
	
	public USAdapter(USPlugpoint plugPoint) {
		this.plugPoint = plugPoint;
	}

	@Override
	public void insertAdapter() {
		plugPoint.insertPlug();
	}

}
