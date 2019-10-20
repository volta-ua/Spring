package com.yet.spring.core.loggers;

import com.yet.spring.core.Event;

public class ConsoleEventLogger implements EventLogger{
	
	public void logEvent(Event e) {
		System.out.println("Console: "+e);
	}

}
