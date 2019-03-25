package designpatterns.adapter;

public class IndianVaccumCleaner {
	
	
	public static void main(String[] args) {
		IAdapter adapter = new USAdapter(new USPlugpoint());
		adapter.insertAdapter();
		adapter = new UKAdapter(new UKPlugpoint());
		adapter.insertAdapter();
	}
}
