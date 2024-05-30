package com.lexmatos.vesting.event.adapter;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import com.lexmatos.vesting.event.domain.Event;
import com.lexmatos.vesting.event.repository.EventCsv;
import com.lexmatos.vesting.event.repository.EventRepositoryCsv;

public class EventRepositoryAdapter implements EventRepository {

	private final EventRepositoryCsv eventRepositoryCsv;
	
	public EventRepositoryAdapter(final EventRepositoryCsv eventRepositoryCsv) {
		this.eventRepositoryCsv = eventRepositoryCsv;
	}
	@Override
	public List<Event> findAll() {
		
		List<EventCsv> eventCsvs = null;
		try {
			eventCsvs = eventRepositoryCsv.findAll();
		} catch (IllegalStateException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return eventCsvs.stream().map(this::build).collect(Collectors.toList());
	}
	
	private Event build(EventCsv eventCsv) {
		Event event = null;
		
		try {
			event = Event.builder()
					.command(eventCsv.getCommand())
					.awardId(eventCsv.getAwardId())
					.employeeId(eventCsv.getEmployeeId())
					.employeeName(eventCsv.getEmployeeName())
					.date(new SimpleDateFormat("yyyy-MM-dd").parse(eventCsv.getDate()))
					.quantity(eventCsv.getQuantity())
					.build();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return event;
	}


}
