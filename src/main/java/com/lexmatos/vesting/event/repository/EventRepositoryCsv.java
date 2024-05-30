package com.lexmatos.vesting.event.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class EventRepositoryCsv {
	
	private String fileName = "vesting.csv";
	
	public EventRepositoryCsv(String filename) {
		this.fileName = filename;
	}
	
	public List<EventCsv> findAll() throws IllegalStateException, FileNotFoundException {
		
		List<EventCsv> events = new CsvToBeanBuilder<EventCsv>(new FileReader(fileName))
	             .withType(EventCsv.class)
	             .build()
	             .parse();
	     
		return events;
	}
}
