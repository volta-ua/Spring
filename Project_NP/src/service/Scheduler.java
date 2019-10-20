package service;

import model.ItemsHolder;

public class Scheduler {
	
	private static ItemsHolder itemHolder;
	
	Scheduler(ItemsHolder itemHolder){
		Scheduler.itemHolder=itemHolder;
	}
	
	public static void runPermanentAction(long periodMin) {
		while(true) {
			try {
				Thread.sleep(periodMin*60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
	

