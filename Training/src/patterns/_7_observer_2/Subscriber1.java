package patterns._7_observer_2;

public class Subscriber1 implements PublisherActionListener{

	@Override
	public void doAction(String message) {
		System.out.println(this.getClass().getSimpleName()+message);
		
	}
	
}
