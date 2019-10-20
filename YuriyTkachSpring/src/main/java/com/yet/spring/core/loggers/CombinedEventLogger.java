package com.yet.spring.core.loggers;

import java.util.Collection;

import com.yet.spring.core.Event;

public class CombinedEventLogger implements EventLogger{
	
	Collection<EventLogger> loggers;
	
	CombinedEventLogger(Collection<EventLogger> loggers){
		this.loggers=loggers;
	}

	public void logEvent(Event e) {
		
		for(EventLogger el : loggers) {
			
		}
		
	}

}
