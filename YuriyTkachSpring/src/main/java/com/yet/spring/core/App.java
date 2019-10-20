package com.yet.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.EventLogger;

public class App 
{	
	private Client client;
	private EventLogger eventLogger;
	
    public App(Client client, EventLogger eventLogger) {
		this.client = client;
		this.eventLogger = eventLogger;
	}

	public static void main( String[] args )
    {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");		
		
		App app=(App)ctx.getBean("app");
		Event e=(Event)ctx.getBean("event");
		e.setMessage("Message is set manually");
		
		for (int i=0;i<11;i++) {
			app.logEvent(e);
		}
		
		ctx.close();
						
    }
    
    public void logEvent(Event e) {
    	eventLogger.logEvent(e);
    }
    
}
