package com.yet.spring.core;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.EventLogger;

public class App 
{	
	private Client client;
	private EventLogger eventLogger;
	private Map<EventType,EventLogger>loggers;
	private EventLogger defaultLogger;
	
    public App(Client client, EventLogger eventLogger,
    		Map<EventType,EventLogger> loggers) {
		this.client = client;
		this.eventLogger = eventLogger;
		this.loggers = loggers;
	}    
    
    public EventLogger getDefaultLogger() {
		return defaultLogger;
	}

	public void setDefaultLogger(EventLogger defaultLogger) {
		this.defaultLogger = defaultLogger;
	}

	public static void main( String[] args ) throws InterruptedException
    {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");		
		
		App app=(App)ctx.getBean("app");
		for (int i=0;i<11;i++) {
			Event e=(Event)ctx.getBean("event");
			e.setMessage("Message is set manually");
			
			int actTypeNumber=i % 3;
			EventType actType;
			switch (actTypeNumber){
				case 0:
					actType=EventType.ERROR;
					break;
				case 1:
					actType=EventType.INFO;
					break;
				default:
					actType=null;
			}
			
			app.logEvent(actType,e);
			Thread.sleep(10);
		}
		
		((ClassPathXmlApplicationContext)ctx).close();			
    }
    
    public void logEvent(EventType type, Event e) {
    	EventLogger logger=loggers.get(type);
    	if (logger==null) {
    		logger=defaultLogger;
    	}
    	logger.logEvent(e);
    }
    
}
