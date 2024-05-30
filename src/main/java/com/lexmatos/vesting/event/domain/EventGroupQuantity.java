package com.lexmatos.vesting.event.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EventGroupQuantity implements EventGroup {
	
	private final String CANCEL = "CANCEL"; 
	
	@Override
	public List<Event> group(List<Event> events){
		
		Set<Event> eventSet = new HashSet<>(events);
		
		for (Event unique : eventSet) {
			float sum = 0;
			for (Event list : events) {
				if (unique.equals(list)) {
					if (!CANCEL.equals(list.getCommand())) {
						sum += list.getQuantity();
					} else {
						sum -= list.getQuantity();
					}
				}
				if (sum != 0) unique.setQuantity(sum);
			}
		}
		return new ArrayList<>(eventSet);
	}
}
