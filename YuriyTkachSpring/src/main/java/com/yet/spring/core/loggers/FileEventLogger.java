package com.yet.spring.core.loggers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.yet.spring.core.Event;

public class FileEventLogger implements EventLogger {
	
	private String fileName;	
	private File file;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	public void logEvent(Event e) {
		File file=new File(fileName);
		String data=e.toString()+System.getProperty("line.separator");
		try {
			FileUtils.writeStringToFile(file, data,true);
			System.out.println("File is written");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void init() throws IOException {
		this.file=new File(fileName);
		System.out.println("Access for reading: "+file.canRead());
	}
	
}
