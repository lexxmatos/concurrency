package com.lexmatos.vesting.event.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EventSummation {
	
	public List<Event> sum(List<Event> eventListFull, List<Event> eventSet){
		
		Set<Event> eventSetFull = new HashSet<>(eventListFull);
		eventSetFull.removeAll(eventSet);
		eventSetFull.stream().forEach(o -> o.setQuantity(0f));
		eventSet.addAll(eventSetFull);
		
		List<Event> eventOrder = new ArrayList<>(eventSet);
		
		//should be ordered by Employee ID and Award ID
		Comparator<Event> compareEmployeeId = Comparator.comparing( Event::getEmployeeId );
		Comparator<Event> compareAwardId = Comparator.comparing( Event::getAwardId );
		 
		Comparator<Event> compareFull = compareEmployeeId.thenComparing(compareAwardId);
		
		return eventOrder.stream().sorted(compareFull).collect(Collectors.toList());
	}
}
