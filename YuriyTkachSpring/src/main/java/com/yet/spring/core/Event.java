package com.yet.spring.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
	
	private int id;
	private String message;
	private Date date;
	private DateFormat df;
	
	public Event(Date date, DateFormat df) {
		this.date = date;
		this.df = df;
		id=ThreadLocalRandom.current().nextInt(100, 999 + 1);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", message=" + message + ", date=" + df.format(date) + "]";
	}
	
}
