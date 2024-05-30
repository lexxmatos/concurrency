package com.lexmatos.vesting.event.domain;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class EventFilterDate implements EventFilter {
	
	private GenericFilter<Event> eventFilter = new GenericFilter<Event>();
	private Date date;
	
	public EventFilterDate(Date date) {
		this.date = date;
	}

	public List<Event> filter (List<Event> events){
		
		return filter(events, this.date);
	}
	@Override
	public List<Event> filter (List<Event> events, Date date){
		
		Predicate<Event> eventDate = event -> date.after(event.getDate()) || date.equals(event.getDate());
		
		return eventFilter.filter(events, eventDate);
	}
}
