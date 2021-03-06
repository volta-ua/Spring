package com.yet.spring.core.loggers;

import java.util.LinkedList;
import java.util.List;

import com.yet.spring.core.Event;

public class CacheFileEventLogger extends FileEventLogger {
	
	private int casheSize;
	List<Event>cashe;

	public CacheFileEventLogger(String fileName, int casheSize) {
		super(fileName);
		this.casheSize=casheSize;
		cashe=new LinkedList<Event>();		
	}
	
	@Override
	public void logEvent(Event e) {
		cashe.add(e);
		if (cashe.size()==casheSize) {
			writeEventsFromCashe();
			cashe.clear();
		}		
	}
	
	private void writeEventsFromCashe() {
		for(Event event: cashe) {	
			super.logEvent(event);
		}
		System.out.println("Saving ...");
	}
	
	public void destroy() {
		if (!cashe.isEmpty())
			writeEventsFromCashe();
		System.out.println("Destroyed ...");
	}
	
}
