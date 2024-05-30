package com.lexmatos.vesting.event;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.lexmatos.vesting.event.adapter.EventRepository;
import com.lexmatos.vesting.event.adapter.EventRepositoryAdapter;
import com.lexmatos.vesting.event.domain.Event;
import com.lexmatos.vesting.event.repository.EventCsv;
import com.lexmatos.vesting.event.repository.EventRepositoryCsv;


public class EventRepositoryTest {
	
	private EventRepository eventRepository = new EventRepositoryAdapter(new EventRepositoryCsv("vesting.csv"));

//	@Test
	public void findAllEvent() throws IllegalStateException, FileNotFoundException {
		
		EventRepositoryCsv eventRepository = new EventRepositoryCsv("vesting.csv");
		List<EventCsv> eventCsvs = eventRepository.findAll();  
		
        Assertions.assertEquals(8,eventCsvs.size());
        Assertions.assertEquals(1000f,eventCsvs.get(0).getQuantity());
	}
	
//	@Test
	public void findAllEventRepsoitoryAdapter() {
		
		List<Event> events = eventRepository.findAll();
		
        Assertions.assertEquals(8,events.size());
        Assertions.assertEquals(1000f,events.get(0).getQuantity());
	}
}
