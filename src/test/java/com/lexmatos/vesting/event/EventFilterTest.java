package com.lexmatos.vesting.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lexmatos.vesting.event.domain.Event;
import com.lexmatos.vesting.event.domain.EventFilterDate;
import com.lexmatos.vesting.event.domain.EventGroupQuantity;
import com.lexmatos.vesting.event.domain.EventSummation;
import com.lexmatos.vesting.event.domain.VestingEvent;

@DisplayName("Filtrar o produto")
class EventFilterTest {
	
	@Test
	void eventFractionalTest() throws ParseException {
		
		List<Event> vest =  Arrays.asList(
			new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),1000.5f),
			new Event("CANCEL","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),700.75f),
			new Event("VEST","E002","Bobby Jones","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),234f)
		);
		
		VestingEvent vestingEvent = VestingEvent.builder()
				.events(vest)
				.filter(new EventFilterDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01")))
				.group(new EventGroupQuantity())
				.eventSummation(new EventSummation())
				.precision(1)
				.build();
		
		List<Event> eventSorted = vestingEvent.getSummation();
		//eventSorted.stream().forEach(System.out::println);
		
        Assertions.assertEquals(2,eventSorted.size());
        Assertions.assertEquals(299.8f,eventSorted.get(0).getQuantity());
	}
	
	@Test
	void eventCancellationTest() throws ParseException {
		
		List<Event> vest =  Arrays.asList(
			new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01,1000"),1000f),
			new Event("CANCEL","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01,700"),700f)
		);
		
		VestingEvent vestingEvent = VestingEvent.builder()
				.events(vest)
				.filter(new EventFilterDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01")))
				.group(new EventGroupQuantity())
				.eventSummation(new EventSummation())
				.build();
		
		List<Event> eventSorted = vestingEvent.getSummation();
		
        Assertions.assertEquals(1,eventSorted.size());
        Assertions.assertEquals(300,eventSorted.get(0).getQuantity());		
	}
	
	@Test
	void eventCancellationMultiTest() throws ParseException {
		
		List<Event> vest =  Arrays.asList(
			new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),1000f),
			new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),1000f),
			new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-01"),300f),
			new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01"),500f),
			new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02"),100f),
			new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-02"),200f),
			new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-02"),300f),
			new Event("CANCEL","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01,700"),700f),
			new Event("VEST","E003","Cat Helms","NSO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),100f)
		);
		
		VestingEvent vestingEvent = VestingEvent.builder()
				.events(vest)
				.filter(new EventFilterDate(new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01")))
				.group(new EventGroupQuantity())
				.eventSummation(new EventSummation())
				.build();
		
		List<Event> eventSorted = vestingEvent.getSummation();

        Assertions.assertEquals(4,eventSorted.size());
        Assertions.assertEquals(1300,eventSorted.get(0).getQuantity());		
	}	
	
	@Test
	void eventFilterTest() throws ParseException {
		
		List<Event> vest =  Arrays.asList(
			new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),1000f),
			new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),1000f),
			new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-01"),300f),
			new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01"),500f),
			new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02"),100f),
			new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-02"),200f),
			new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-02"),300f),
			new Event("VEST","E003","Cat Helms","NSO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),100f)
		);
		
		VestingEvent vestingEvent = VestingEvent.builder()
				.events(vest)
				.filter(new EventFilterDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01")))
				.group(new EventGroupQuantity())
				.eventSummation(new EventSummation())
				.build();
		
		List<Event> eventSorted = vestingEvent.getSummation();
//		System.out.println("List Event Set Sum Full");
//		eventSorted.stream().forEach(System.out::println);

        Assertions.assertEquals(4,eventSorted.size());
        Assertions.assertEquals(1000,eventSorted.get(0).getQuantity());
        Assertions.assertEquals(800,eventSorted.get(1).getQuantity());
        Assertions.assertEquals(600,eventSorted.get(2).getQuantity());
        Assertions.assertEquals(0,eventSorted.get(3).getQuantity());
	}
	
	@Test
	void eventFilterDateTest() throws ParseException {
		
		List<Event> vest =  Arrays.asList(new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),1000f),
				new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),1000f),
				new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-01"),300f),
				new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01"),500f),
				new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02"),100f),
				new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-02"),200f),
				new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-02"),300f),
				new Event("VEST","E003","Cat Helms","NSO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),100f)
				);
		
		EventFilterDate  eventFilter = new EventFilterDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01"));
		
		List<Event> eventFilterResult  = eventFilter.filter(vest);
		
		//System.out.println("List Event Filter Result");
		//eventFilterResult.stream().forEach(System.out::println);
		
        Assertions.assertEquals(6,eventFilterResult.size());
	}
	
	@Test
	void eventGroupQuantityTest() throws ParseException {
		
		List<Event> vest =  Arrays.asList(new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"),1000f),
				new Event("VEST","E001","Alice Smith","ISO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),1000f),
				new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-01"),300f),
				new Event("VEST","E001","Alice Smith","ISO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-01"),500f),
				new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02"),100f),
				new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-02"),200f),
				new Event("VEST","E002","Bobby Jones","NSO-001",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-02"),300f),
				new Event("VEST","E003","Cat Helms","NSO-002",new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),100f)
				);		
		
		EventGroupQuantity eventGroup = new EventGroupQuantity(); 
		List<Event> eventSet = eventGroup.group(vest);
		
        Assertions.assertEquals(4,eventSet.size());
        Assertions.assertEquals(100,eventSet.get(0).getQuantity());
        Assertions.assertEquals(800,eventSet.get(1).getQuantity());
        Assertions.assertEquals(2000,eventSet.get(2).getQuantity());
        Assertions.assertEquals(600,eventSet.get(3).getQuantity());		
	}
	
}
