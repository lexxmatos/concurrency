package com.lexmatos.vesting.event.domain;

import java.util.List;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VestingEvent {
	
	private float truncate(float value, int places) {
	    double scale = Math.pow(10, places);
	    
	    return (float) (Math.round(value * scale) / scale);
	    
	    //roundAvoid(1000.0d, 17)
	}
	private List<Event> events;
	
	private EventFilter  filter;
	private EventGroup group;
	private EventSummation eventSummation = new EventSummation();
	private int precision; 
	
	public List<Event> getSummation(){
		
		List<Event> eventGroup = group.group(filter.filter(events));
		eventGroup = eventSummation.sum(events, eventGroup);
		eventGroup.forEach(o -> o.setQuantity(truncate(o.getQuantity(),precision)));
		
		return eventGroup;
	}
}
