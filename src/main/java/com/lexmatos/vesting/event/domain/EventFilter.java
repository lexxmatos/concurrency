package com.lexmatos.vesting.event.domain;

import java.util.Date;
import java.util.List;

public interface EventFilter {

	List<Event> filter (List<Event> events);	
	List<Event> filter (List<Event> events, Date date);
}
